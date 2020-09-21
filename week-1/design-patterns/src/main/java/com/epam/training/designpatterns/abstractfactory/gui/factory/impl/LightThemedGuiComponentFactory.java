package com.epam.training.designpatterns.abstractfactory.gui.factory.impl;

import com.epam.training.designpatterns.abstractfactory.gui.Button;
import com.epam.training.designpatterns.abstractfactory.gui.Label;
import com.epam.training.designpatterns.abstractfactory.gui.factory.GuiComponentFactory;
import com.epam.training.designpatterns.abstractfactory.gui.impl.LightThemedButton;
import com.epam.training.designpatterns.abstractfactory.gui.impl.LightThemedLabel;

public class LightThemedGuiComponentFactory implements GuiComponentFactory {

    @Override
    public Button createButton(String text) {
        return new LightThemedButton(text);
    }

    @Override
    public Label createLabel(String text) {
        return new LightThemedLabel(text);
    }
}
