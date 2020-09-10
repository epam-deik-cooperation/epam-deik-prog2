package com.epam.training.exercise;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ParserExercise {

    public void parse() throws XMLStreamException, TransformerException, FileNotFoundException {
        Document document = SVGDOMImplementation.getDOMImplementation().createDocument(SVGDOMImplementation.SVG_NAMESPACE_URI, "svg", null);

        createDOMSource(document);
        /**
         * TODO
         * 1. Parse XML -> készítsd el a saját koordináta kollekciódat az input.xml fájl alapján
         * 2. Opcionális: Csoportosítsd államok/megyék szerint a városokat
         *  Ha ezt a lépést kihagyod akkor az összes államot jelenítsd meg azonos színnel -> a szín legyen random generált
         *  Ha elvégzed a csoportosítást akkor az államokat/megyéket külön random generált színnel jelenítsd meg (látszódjanak jól a határok!)
         * 3.Végül koordináták jelenítsd meg az SVG fájlban egy pont formájában
         */

        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult("OUTPUT SVG"));
    }

    private void createDOMSource(Document document) throws FileNotFoundException, XMLStreamException {
        XMLStreamReader xmlStreamReader = XMLInputFactory.newFactory().createXMLStreamReader(new FileInputStream("INPUT XML"));
        List<City> cityList = createCityList(xmlStreamReader);

        Element rootElement = document.getDocumentElement();
        rootElement.setAttributeNS(null, "width", "800");
        rootElement.setAttributeNS(null, "height", "600");

        cityList.forEach(yourModel -> {
            Element element = document.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "circle");
            // cy -> X koordináta értéke!
            element.setAttributeNS(null, "cy", "...");
            // cx -> Y koordináta értéke!
            element.setAttributeNS(null, "cx", "...");
            // fill -> random hexadecimális szín!
            element.setAttributeNS(null, "fill", "...");
            // r -> a pont átmérőjét jelenti -> legyen 1!
            element.setAttributeNS(null, "r", "...");
            rootElement.appendChild(element);
        });
    }

    private List<City> createCityList(XMLStreamReader xmlStreamReader) {
        return null;
    }

}
