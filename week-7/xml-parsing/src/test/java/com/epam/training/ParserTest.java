package com.epam.training;

import com.epam.training.solution.ParserSolution;
import org.junit.Test;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

public class ParserTest {

    private final ParserSolution underTest = new ParserSolution();

    @Test
    public void testParse() throws TransformerException, XMLStreamException, FileNotFoundException {
        underTest.parse();
    }

}
