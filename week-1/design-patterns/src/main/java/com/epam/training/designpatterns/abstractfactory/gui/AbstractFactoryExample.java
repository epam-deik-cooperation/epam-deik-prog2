package com.epam.training.designpatterns.abstractfactory.gui;

import com.epam.training.designpatterns.abstractfactory.gui.factory.GuiComponentFactory;
import com.epam.training.designpatterns.abstractfactory.gui.factory.impl.DarkThemedGuiComponentFactory;

public class AbstractFactoryExample {

    public static void main(String[] args) {
        GuiComponentFactory componentFactory = new DarkThemedGuiComponentFactory();
        // A SomeWindow osztály a GuiComponentFactory-tól függ, így akár a másik factory implementációt is gond nélkül injektálhatnánk.
        SomeWindow window = new SomeWindow(componentFactory);
        window.updateGui();
    }

}
