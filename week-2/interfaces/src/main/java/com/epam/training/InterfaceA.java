package com.epam.training;

public interface InterfaceA {

	default public void method() {
		System.out.println("InterfaceA.method()");
	}
	
}
