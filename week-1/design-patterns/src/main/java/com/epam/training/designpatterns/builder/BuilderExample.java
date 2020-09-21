package com.epam.training.designpatterns.builder;

import com.epam.training.designpatterns.builder.impl.TextDocumentBuilder;

public class BuilderExample {

    public static void main(String[] args) {
        DocumentBuilder builder = new TextDocumentBuilder();
        DocumentGenerator generator = new DocumentGenerator(builder);
        Document document = generator.generateDocument();
        document.saveToFile("./someFileName");
    }

}
