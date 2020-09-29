package com.epam.training.designpatterns.builder;

import java.util.List;

public interface DocumentBuilder {
    DocumentBuilder withTitle(String title);
    DocumentBuilder addParagraph(String paragraph);
    DocumentBuilder addUnorderedList(List<String> items);
    DocumentBuilder addOrderedList(List<String> items);
    Document buildDocument();
}
