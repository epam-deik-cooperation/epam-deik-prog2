package com.epam.training.solution;

import com.epam.training.solution.City.CityBuilder;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ParserSolution {

    private static final String INPUT_FILE = "src/main/resources/input.xml";
    private static final String OUTPUT_FILE = "src/main/resources/map.svg";

    public void parse() throws XMLStreamException, TransformerException, FileNotFoundException {
        Document document = SVGDOMImplementation.getDOMImplementation()
                .createDocument(SVGDOMImplementation.SVG_NAMESPACE_URI, "svg", null);

        createDOMSource(document);

        TransformerFactory.newInstance().newTransformer()
                .transform(new DOMSource(document), new StreamResult(OUTPUT_FILE));
    }

    private void createDOMSource(Document document) throws XMLStreamException, FileNotFoundException {
        List<City> cityList = createCityList();
        Map<String, String> colorsOfStates = createColorsOfStates(cityList);
        Element rootElement = createRootElement(document);

        cityList.forEach(city -> {
            Element element = document.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "circle");
            element.setAttributeNS(null, "cy", city.getCoordinateX());
            element.setAttributeNS(null, "cx", city.getCoordinateY());
            element.setAttributeNS(null, "fill", colorsOfStates.get(city.getState()));
            element.setAttributeNS(null, "r", "1");
            rootElement.appendChild(element);
        });
    }

    private Element createRootElement(Document document) {
        Element rootElement = document.getDocumentElement();
        rootElement.setAttributeNS(null, "width", "800");
        rootElement.setAttributeNS(null, "height", "600");
        return rootElement;
    }

    private Map<String, String> createColorsOfStates(List<City> cityList) {
        return cityList.stream()
                .map(City::getState)
                .distinct()
                .collect(Collectors.toMap(hexColor -> hexColor, hexColor -> randomHexColor()));
    }

    private List<City> createCityList() throws XMLStreamException, FileNotFoundException {
        XMLStreamReader xmlStreamReader = XMLInputFactory.newFactory().createXMLStreamReader(new FileInputStream(INPUT_FILE));
        List<City> cityList = new LinkedList<>();
        CityBuilder builder = City.builder();

        while (xmlStreamReader.hasNext()) {
            int actual = xmlStreamReader.next();
            if (isStartElement(actual, "coordinateX", xmlStreamReader)) {
                builder.coordinateX(xmlStreamReader.getElementText());
            } else if (isStartElement(actual, "coordinateY", xmlStreamReader)) {
                builder.coordinateY(xmlStreamReader.getElementText());
            } else if (isStartElement(actual, "state", xmlStreamReader)) {
                builder.state(xmlStreamReader.getElementText());
            } else if (isEndElement(actual, "city", xmlStreamReader)) {
                cityList.add(builder.build());
            }
        }
        return cityList;
    }

    private boolean isStartElement(int actual, String tagName, XMLStreamReader xmlStreamReader) {
        return actual == XMLStreamReader.START_ELEMENT && tagName.equals(xmlStreamReader.getLocalName());
    }

    private boolean isEndElement(int actual, String tagName, XMLStreamReader xmlStreamReader) {
        return actual == XMLStreamReader.END_ELEMENT && tagName.equals(xmlStreamReader.getLocalName());
    }

    private String randomHexColor() {
        return String.format("#%06X", new Random().nextInt(0x1000000));
    }

}
