package com.epam.training;

import java.util.Arrays;

public class IntegerCollection {

	int[] array;
	int index = 0;
	int size;
	boolean sorted = true;

	public IntegerCollection(int size) {
		this.size = size;
		this.array = new int[size];
	}

	public IntegerCollection(int[] array) {
		this.size = array.length;
		this.index = this.size;
		this.array = array;
		this.sorted = false;
	}

	public void add(int value) {
		if (size <= index) {
			throw new IllegalArgumentException("The collection is full");
		}
		sorted = false;
		array[index++] = value;
	}

	public boolean contains(int value) {
		if (!sorted) {
			sort();
		}

		int left = 0, right = size - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == value) {
				return true;
			}

			if (array[mid] < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}

	public int[] sort() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		sorted = true;
		return array;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof IntegerCollection)) {
			return false;
		}
		IntegerCollection other = (IntegerCollection) obj;
		return Arrays.equals(array, other.array);
	}

	@Override
	public String toString() {
		return "IntegerCollection [array=" + Arrays.toString(array) + "]";
	}

}
