package com.epam.training.designpatterns.factorymethod.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.designpatterns.factorymethod.Label;

public class LightThemedLabel implements Label {

    private final static Logger LOGGER = LoggerFactory.getLogger(LightThemedLabel.class);

    private String text;

    public LightThemedLabel(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        LOGGER.info("I'm drawing a light themed label with the text of {}! Yay!", text);
    }
}
