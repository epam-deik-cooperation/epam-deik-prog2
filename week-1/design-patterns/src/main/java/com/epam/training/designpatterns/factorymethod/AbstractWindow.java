package com.epam.training.designpatterns.factorymethod;

import java.util.List;

public abstract class AbstractWindow {

    private List<GuiComponent> guiComponents;

    public AbstractWindow() {
        guiComponents = createGuiComponents();
    }

    private List<GuiComponent> createGuiComponents() {
        /* Dolgozunk a Button és Label példányokkal, de azt a gyermekosztályra bízzuk,
        *  hogy pontosan melyik implementációval.
        */
        return List.of(
            this.createButton("Text for some button on this window"),
            this.createLabel("Text for some label on this window")
        );
    }

    public void updateGui() {
        guiComponents.forEach(GuiComponent::draw);
    }

    protected abstract Button createButton(String text);
    protected abstract Label createLabel(String text);
}
