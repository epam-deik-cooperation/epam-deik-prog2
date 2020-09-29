package com.epam.training.designpatterns.prototype;

import java.util.List;

public class DocumentGenerator {

    private DocumentBuilder documentBuilder;

    public DocumentGenerator(DocumentBuilder documentBuilder) throws CloneNotSupportedException {
        this.documentBuilder = (DocumentBuilder) documentBuilder.clone();
    }

    public Document generateDocument() {
        // Ebben az osztályban nem számít, milyen dokumentumot hozunk létre, a felépítéséhez szükséges lépések vannak csak definiálva
        return documentBuilder
            .withTitle("Some title")
            .addParagraph("This is a paragraph")
            .addOrderedList(List.of("This", "is", "an", "ordered", "list"))
            .addUnorderedList(List.of("This", "is", "an", "unordered", "list"))
            .buildDocument();
    }
}
