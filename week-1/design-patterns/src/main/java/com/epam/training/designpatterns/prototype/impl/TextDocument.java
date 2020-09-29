package com.epam.training.designpatterns.prototype.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.designpatterns.prototype.Document;

public class TextDocument implements Document {

    private final static Logger LOGGER = LoggerFactory.getLogger(TextDocument.class);

    private List<String> lines;

    public TextDocument(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public void saveToFile(String fileName) {
        LOGGER.info("Saving text document to file {} with lines {}", fileName, lines);
    }
}
