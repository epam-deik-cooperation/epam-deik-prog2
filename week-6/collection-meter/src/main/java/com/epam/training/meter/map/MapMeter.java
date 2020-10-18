package com.epam.training.meter.map;

import java.util.Map;
import java.util.function.Supplier;

import com.epam.training.meter.AbstractCollectionMeter;

public class MapMeter extends AbstractCollectionMeter<Map<String, Integer>> {

	public MapMeter(Supplier<Map<String, Integer>> mapSupplier) {
		super(mapSupplier);
	}

	@Override
	public void addElement(Map<String, Integer> map, Integer element) {
		map.put(String.valueOf(element), element);
	}

	@Override
	public void removeElement(Map<String, Integer> map, Integer element) {
		map.remove(String.valueOf(element));
	}

	@Override
	public void getElement(Map<String, Integer> map, Integer element) {
		map.get(String.valueOf(element));
	}

}
