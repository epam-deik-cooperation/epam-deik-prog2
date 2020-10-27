package com.epam.training.meter.list;

import java.util.List;
import java.util.function.Supplier;

import com.epam.training.meter.AbstractCollectionMeter;

public class ListMeter extends AbstractCollectionMeter<List<String>> {

	public ListMeter(Supplier<List<String>> listSupplier) {
		super(listSupplier);
	}

	@Override
	public void addElement(List<String> list, Integer element) {
		list.add(String.valueOf(element));
	}

	@Override
	public void removeElement(List<String> list, Integer element) {
		list.remove(String.valueOf(element));
	}

	@Override
	public void getElement(List<String> list, Integer element) {
		list.get(element);
	}

}
