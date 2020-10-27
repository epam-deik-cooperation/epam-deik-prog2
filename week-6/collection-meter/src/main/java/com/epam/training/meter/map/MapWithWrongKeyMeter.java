package com.epam.training.meter.map;

import java.util.Map;
import java.util.function.Supplier;

import com.epam.training.meter.AbstractCollectionMeter;

public class MapWithWrongKeyMeter extends AbstractCollectionMeter<Map<MapWithWrongKeyMeter.WrongClass, Integer>> {

	public MapWithWrongKeyMeter(Supplier<Map<MapWithWrongKeyMeter.WrongClass, Integer>> mapSupplier) {
		super(mapSupplier);
	}

	@Override
	public void addElement(Map<WrongClass, Integer> map, Integer element) {
		map.put(new WrongClass(String.valueOf(element)), element);
	}

	@Override
	public void removeElement(Map<WrongClass, Integer> map, Integer element) {
		map.remove(new WrongClass(String.valueOf(element)));
	}

	@Override
	public void getElement(Map<WrongClass, Integer> map, Integer element) {
		map.get(new WrongClass(String.valueOf(element)));
	}

	public static class WrongClass {

		private String string;

		public WrongClass(String string) {
			super();
			this.string = string;
		}

		public String getString() {
			return string;
		}

		@Override
		public int hashCode() {
			return 1;
		}

	}

}
