package com.epam.training;

public class Car extends Vehicle {

    public Car() {
        System.out.println("Creating car!");
    }

    @Override
    void start() {
        System.out.println("Car is starting!");
    }

}
