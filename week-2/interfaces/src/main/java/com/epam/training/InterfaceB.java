package com.epam.training;

public interface InterfaceB {

	default public void method() {
		System.out.println("InterfaceB.method()");
	}
	
}
