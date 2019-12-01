package exercise;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.*;
import java.util.Iterator;


/**
 * XMLParser class for parsing xml documents.
 */
public class XMLParser{
    public static String filePath;


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
        double bottomradi = 0;
        double heighcone = 0;
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
                if (element.getName().toString() == "Sphere") {
                
                	 Iterator<Attribute> iterator =element.getAttributes();
                	 while(iterator.hasNext()) {
                		 Attribute attribute = iterator.next();
                		 QName rad = attribute.getName();
                		 if("radius".equalsIgnoreCase(rad.getLocalPart())) {
                			 double radi = Double.valueOf(attribute.getValue()); 
                			 Vec3D cent = new Vec3D(0.0,0.0,0.0);
                			 Sphere mysphere = new Sphere(radi,cent);
                		 }
                	 }
                }
                if (element.getName().toString() == "Cone") {
                	Iterator<Attribute> iterator =element.getAttributes();
               	 while(iterator.hasNext()) {
               		 Attribute attribute = iterator.next();
               		 QName rad1 = attribute.getName();
               		 if("bottomRadius".equalsIgnoreCase(rad1.getLocalPart())) {
               			  bottomradi = Double.valueOf(attribute.getValue()); 
               			 }
               		if("height".equalsIgnoreCase(rad1.getLocalPart())) {
              			 heighcone = Double.valueOf(attribute.getValue()); 
              		 }
               		Vec3D apex = new Vec3D(0.0,0.0,0.0);
               		System.out.println(apex);
					Cone mycone = new Cone(apex, bottomradi, heighcone);
               	 }     	
                }
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
