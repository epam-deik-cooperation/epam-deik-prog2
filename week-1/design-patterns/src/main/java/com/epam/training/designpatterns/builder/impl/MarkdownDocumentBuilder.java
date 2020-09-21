package com.epam.training.designpatterns.builder.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.training.designpatterns.builder.Document;
import com.epam.training.designpatterns.builder.DocumentBuilder;

public class MarkdownDocumentBuilder implements DocumentBuilder {

    private List<String> lines = new LinkedList<>();

    @Override
    public DocumentBuilder withTitle(String title) {
        lines.add("# " + title);
        return this;
    }

    @Override
    public DocumentBuilder addParagraph(String paragraph) {
        lines.add("");
        lines.add(paragraph);
        return this;
    }

    @Override
    public DocumentBuilder addUnorderedList(List<String> items) {
        lines.addAll(items.stream()
            .map(item -> "* " + item)
            .collect(Collectors.toList())
        );
        return this;
    }

    @Override
    public DocumentBuilder addOrderedList(List<String> items) {
        lines.addAll(items.stream()
            .map(item -> "1. " + item)
            .collect(Collectors.toList())
        );
        return this;
    }

    @Override
    public Document buildDocument() {
        return new MarkdownDocument(lines);
    }
}
