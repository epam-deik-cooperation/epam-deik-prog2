package com.epam.training.designpatterns.factorymethod;


import com.epam.training.designpatterns.factorymethod.impl.DarkThemedButton;
import com.epam.training.designpatterns.factorymethod.impl.DarkThemedLabel;

public class DarkThemedWindow extends AbstractWindow {
    @Override
    protected Button createButton(String text) {
        return new DarkThemedButton(text);
    }

    @Override
    protected Label createLabel(String text) {
        return new DarkThemedLabel(text);
    }
}
