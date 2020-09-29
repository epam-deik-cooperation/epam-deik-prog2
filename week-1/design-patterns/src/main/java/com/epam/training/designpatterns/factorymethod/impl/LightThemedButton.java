package com.epam.training.designpatterns.factorymethod.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.designpatterns.factorymethod.Button;


public class LightThemedButton implements Button {

    private final static Logger LOGGER = LoggerFactory.getLogger(LightThemedButton.class);

    private String text;

    public LightThemedButton(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        LOGGER.info("I'm drawing a light themed button with the text of {}! Yay!", text);
    }
}
