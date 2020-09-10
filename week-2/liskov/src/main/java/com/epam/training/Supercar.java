package com.epam.training;

public class Supercar extends Car {

    public Supercar() {
        System.out.println("Creating supercar!");
    }

    @Override
    void start() {
        System.out.println("Supercar is starting!");
    }

}
