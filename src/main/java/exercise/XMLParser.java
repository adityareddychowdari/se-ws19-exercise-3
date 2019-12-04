package exercise;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.*;


/**
 * XMLParser class for parsing xml documents.
 */
public class XMLParser{
    public String filePath;


    public XMLParser(String filePath){
        this.filePath = filePath;
    }


    /**
     * helper function for every open Tag
     */
    public void enter(String openTag){
        System.out.print(openTag);
    }


    /**
     * helper function for every close Tag
     */
    public void exit(String closeTag){
        System.out.print(closeTag);
    }


    /**
     * ref: <https://www.geeksforgeeks.org/stax-xml-parser-java/>
     */
    public void parse() throws XMLStreamException, FileNotFoundException {
        // file input|output
        File file = new File(filePath);;

        // XMLInputFactory for identifying XML tags
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // initializing handler to access the XML tags
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        // iterating through all tags
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();

            // for the opening tag ...
            if (event.isStartElement()){
                StartElement element = (StartElement)event;
                System.out.println();
                enter(element.getName().toString());
            }

            // for the closing tag ...
            if (event.isEndElement()){
                EndElement element = (EndElement) event;
                System.out.println();
                exit(element.getName().toString());
            }
        }
    }
}

