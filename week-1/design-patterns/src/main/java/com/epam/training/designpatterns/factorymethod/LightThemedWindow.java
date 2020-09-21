package com.epam.training.designpatterns.factorymethod;


import com.epam.training.designpatterns.factorymethod.impl.LightThemedButton;
import com.epam.training.designpatterns.factorymethod.impl.LightThemedLabel;

public class LightThemedWindow extends AbstractWindow {
    @Override
    protected Button createButton(String text) {
        return new LightThemedButton(text);
    }

    @Override
    protected Label createLabel(String text) {
        return new LightThemedLabel(text);
    }
}
