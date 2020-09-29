package com.epam.training.designpatterns.prototype;

import com.epam.training.designpatterns.prototype.impl.MarkdownDocumentBuilder;

public class BuilderWithPrototypeExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        DocumentBuilder builder = new MarkdownDocumentBuilder();
        DocumentGenerator generator = new DocumentGenerator(builder);
        Document document = generator.generateDocument();
        document.saveToFile("./someFileName");
    }

}
