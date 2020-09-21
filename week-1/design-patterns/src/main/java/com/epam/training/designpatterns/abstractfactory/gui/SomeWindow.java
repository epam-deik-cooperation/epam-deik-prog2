package com.epam.training.designpatterns.abstractfactory.gui;

import java.util.List;

import com.epam.training.designpatterns.abstractfactory.gui.factory.GuiComponentFactory;

public class SomeWindow {

    private List<GuiComponent> guiComponents;

    public SomeWindow(GuiComponentFactory componentFactory) {
        guiComponents = createGuiComponents(componentFactory);
    }

    private List<GuiComponent> createGuiComponents(GuiComponentFactory componentFactory) {
        return List.of(
            componentFactory.createButton("Text for some button on this window"),
            componentFactory.createLabel("Text for some label on this window")
        );
    }

    public void updateGui() {
        guiComponents.forEach(GuiComponent::draw);
    }
}
