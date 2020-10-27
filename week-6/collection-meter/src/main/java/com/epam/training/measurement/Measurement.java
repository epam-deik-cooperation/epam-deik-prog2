package com.epam.training.measurement;

import java.util.Arrays;
import java.util.List;

import com.epam.training.meter.CollectionMeter;

public class Measurement {

	private final List<CollectionMeter> meters;

	public Measurement(List<CollectionMeter> meters) {
		this.meters = meters;
	}

	public Measurement(CollectionMeter... meters) {
		this.meters = Arrays.asList(meters);
	}

	public Measurement measureCollectionSetup(Integer size) {
		System.out.println("Starting 'collection setup' measuring");
		meters.stream().forEach(meter -> meter.meterCollectionSetup(size));
		return this;
	}

	public Measurement measureFrequentChanges(Integer size) {
		System.out.println("Starting 'frequent change' measuring");
		meters.stream().forEach(meter -> meter.meterFrequentChanges(size));
		return this;
	}

	public Measurement measureGet(Integer size) {
		System.out.println("Starting 'get' measuring");
		meters.stream().forEach(meter -> meter.meterGet(size));
		return this;
	}

}
