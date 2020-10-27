package com.epam.training.meter;

public interface CollectionMeter {

	void meterCollectionSetup(Integer size);

	void meterFrequentChanges(Integer size);

	void meterGet(Integer size);

}
