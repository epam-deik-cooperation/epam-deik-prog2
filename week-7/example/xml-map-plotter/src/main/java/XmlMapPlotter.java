import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlMapPlotter {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        XmlReader reader = new SaxXmlReader(new FileInputStream("input.xml"));
        List<City> cities = reader.getCities();
        MapImage image = new SvgMapImage(800, 600);
        cities.forEach(city -> city.plot(image));
        image.save(new FileWriter("map.svg"));
    }
}
