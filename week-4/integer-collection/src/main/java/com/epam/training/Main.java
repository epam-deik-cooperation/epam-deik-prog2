package com.epam.training;

public class Main {

	public static void main(String[] args) {
		IntegerCollection collection = new IntegerCollection(3);
		collection.add(0);
		collection.add(2);
		collection.add(1);
		System.out.println(collection);
		collection.sort();
		System.out.println(collection);
		System.out.println(collection.contains(0));
		System.out.println(collection.contains(1));
		System.out.println(collection.contains(2));
		System.out.println(collection.contains(3));
		System.out.println(collection.contains(4));
	}

}
