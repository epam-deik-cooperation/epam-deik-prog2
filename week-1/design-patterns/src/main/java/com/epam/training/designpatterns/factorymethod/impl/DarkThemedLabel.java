package com.epam.training.designpatterns.factorymethod.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.designpatterns.factorymethod.Label;

public class DarkThemedLabel implements Label {

    private final static Logger LOGGER = LoggerFactory.getLogger(DarkThemedLabel.class);

    private String text;

    public DarkThemedLabel(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        LOGGER.info("I'm drawing a dark themed label with the text of {}! Yay!", text);
    }
}
