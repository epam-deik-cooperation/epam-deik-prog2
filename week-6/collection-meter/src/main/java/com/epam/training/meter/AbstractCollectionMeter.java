package com.epam.training.meter;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public abstract class AbstractCollectionMeter<T> implements CollectionMeter {

	private Supplier<T> collectionSupplier;

	public AbstractCollectionMeter(Supplier<T> collectionSupplier) {
		this.collectionSupplier = collectionSupplier;
	}

	@Override
	public void meterCollectionSetup(Integer size) {
		T collection = collectionSupplier.get();
		meter(collection, size, this::doCollectionSetup);
	}

	@Override
	public void meterFrequentChanges(Integer size) {
		T collection = collectionSupplier.get();
		meter(collection, size, this::doFrequentChanges);
	}

	@Override
	public void meterGet(Integer size) {
		T collection = collectionSupplier.get();
		doCollectionSetup(collection, size);
		meter(collection, size, this::doGet);
	}

	public abstract void addElement(T collection, Integer element);

	public abstract void removeElement(T collection, Integer element);

	public abstract void getElement(T collection, Integer element);

	private void doCollectionSetup(T collection, Integer size) {
		for (int i = 0; i < size; i++) {
			addElement(collection, i);
		}
	}

	private void doFrequentChanges(T collection, Integer size) {
		doCollectionSetup(collection, size);
		for (int i = 0; i < size; i++) {
			removeElement(collection, i);
		}
	}

	private void doGet(T collection, Integer size) {
		getElement(collection, size / 2);
	}

	private void meter(T collection, Integer size, BiConsumer<T, Integer> meteredAction) {
		long before = System.currentTimeMillis();
		meteredAction.accept(collection, size);
		long after = System.currentTimeMillis();
		long delta = after - before;
		System.out.println(collection.getClass().getSimpleName() + ", Millisec: " + delta);
	}

}
