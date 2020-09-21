package com.epam.training.designpatterns.builder.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.designpatterns.builder.Document;

public class MarkdownDocument implements Document {

    private final static Logger LOGGER = LoggerFactory.getLogger(MarkdownDocument.class);

    private List<String> lines;

    public MarkdownDocument(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public void saveToFile(String fileName) {
        LOGGER.info("Saving markdown document to file {} with lines {}", fileName, lines);
    }
}
