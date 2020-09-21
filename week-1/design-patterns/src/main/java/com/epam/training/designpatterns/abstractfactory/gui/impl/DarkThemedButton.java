package com.epam.training.designpatterns.abstractfactory.gui.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.designpatterns.abstractfactory.gui.Button;

public class DarkThemedButton implements Button {

    private final static Logger LOGGER = LoggerFactory.getLogger(DarkThemedButton.class);

    private String text;

    public DarkThemedButton(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        LOGGER.info("I'm drawing a dark themed button with the text of {}! Yay!", text);
    }
}
