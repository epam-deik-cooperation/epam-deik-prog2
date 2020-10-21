import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class SaxXmlReader extends DefaultHandler implements XmlReader {

    private double currentXCoordinate;
    private double currentYCoordinate;
    private String currentState;

    private Consumer<String> actionOnCharacters = c -> {
    };

    private List<City> result = new LinkedList<>();

    public SaxXmlReader(InputStream input) throws ParserConfigurationException, SAXException, IOException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        parser.parse(input, this);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("coordinateX")) {
            actionOnCharacters = c -> currentXCoordinate = Double.parseDouble(c);
        }
        if (qName.equalsIgnoreCase("coordinateY")) {
            actionOnCharacters = c -> currentYCoordinate = Double.parseDouble(c);
        }
        if (qName.equalsIgnoreCase("state")) {
            actionOnCharacters = c -> currentState = c;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("city")) {
            result.add(new City(currentXCoordinate, currentYCoordinate, currentState));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        actionOnCharacters.accept(new String(ch, start, length));
        actionOnCharacters = c -> {
        };
    }

    @Override
    public List<City> getCities() {
        return result;
    }
}
