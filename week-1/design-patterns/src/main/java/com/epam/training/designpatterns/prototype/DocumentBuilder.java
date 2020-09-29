package com.epam.training.designpatterns.prototype;

import java.util.List;

public interface DocumentBuilder extends Cloneable {
    DocumentBuilder withTitle(String title);
    DocumentBuilder addParagraph(String paragraph);
    DocumentBuilder addUnorderedList(List<String> items);
    DocumentBuilder addOrderedList(List<String> items);
    Document buildDocument();
    Object clone() throws CloneNotSupportedException;
}
