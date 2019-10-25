package exercise;

import org.junit.Test;

import javax.xml.stream.XMLStreamException;

import static org.junit.Assert.assertEquals;

public class XMLParserTest {
    final static String RESOURCE_PATH = "src/test/resources/";

    @Test
    public void XMLParserTest1() throws java.io.FileNotFoundException, java.io.IOException, XMLStreamException {
        XMLParser p = new XMLParser(RESOURCE_PATH + "test1.xml");
        p.parse();
    }

    @Test
    public void XMLParserTest2() throws java.io.FileNotFoundException, java.io.IOException, XMLStreamException {
        XMLParser p = new XMLParser(RESOURCE_PATH + "test2.html");
        p.parse();
    }

    @Test
    public void XMLParserTest3() throws java.io.FileNotFoundException, java.io.IOException, XMLStreamException {
        XMLParser p = new XMLParser(RESOURCE_PATH + "test3.x3d");
        p.parse();
    }

    @Test
    public void PrettyPrintParserTest4() throws java.io.FileNotFoundException, java.io.IOException, XMLStreamException {
        PrettyPrintParser p = new PrettyPrintParser(RESOURCE_PATH + "test1.xml");
        p.parse();
    }

    @Test
    public void PrettyPrintParserTest5() throws java.io.FileNotFoundException, java.io.IOException, XMLStreamException {
        PrettyPrintParser p = new PrettyPrintParser(RESOURCE_PATH + "test2.html");
        p.parse();
    }

    @Test
    public void PrettyPrintParserTest6() throws java.io.FileNotFoundException, java.io.IOException, XMLStreamException {
        PrettyPrintParser p = new PrettyPrintParser(RESOURCE_PATH + "test3.x3d");
        p.parse();
    }
}

