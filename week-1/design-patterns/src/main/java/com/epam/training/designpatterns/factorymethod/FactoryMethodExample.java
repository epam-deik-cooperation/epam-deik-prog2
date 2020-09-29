package com.epam.training.designpatterns.factorymethod;

public class FactoryMethodExample {
    public static void main(String[] args) {
        var lightWindow = new LightThemedWindow();
        var darkWindow = new DarkThemedWindow();
        lightWindow.updateGui();
        darkWindow.updateGui();
    }
}
