package com.epam.training.designpatterns.abstractfactory.gui.factory;

import com.epam.training.designpatterns.abstractfactory.gui.Button;
import com.epam.training.designpatterns.abstractfactory.gui.Label;

public interface GuiComponentFactory {
    Button createButton(String text);
    Label createLabel(String text);
}
