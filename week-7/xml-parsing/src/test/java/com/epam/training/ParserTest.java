package com.epam.training;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.Test;

import com.epam.training.solution.ParserSolution;

public class ParserTest {

    private final ParserSolution underTest = new ParserSolution();

    @Test
    public void testParse() throws TransformerException, XMLStreamException, FileNotFoundException {
        underTest.parse();
    }

}
