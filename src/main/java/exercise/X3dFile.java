package exercise;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.namespace.QName;  

// Resuse XML Parser solve solution
public class X3dFile{
    // filepath should inaccesible outside
    private String filePath;

    // Memmory will be stored in sceneEntities
    public Transform sceneEntities;

    public X3dFile(String filePath) {
        this.filePath = filePath;
        try {
            this.parse();
        } catch (Exception e) {
            System.out.println("Parsing file Fail!");
        }
    }

    public void parse() throws XMLStreamException, FileNotFoundException {
        // file input|output
        File file = new File(filePath);

        // XMLInputFactory for identifying XML tags
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // initializing handler to access the XML tags
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        System.out.println("Start loding...");

        // General pointer is used to iterate through programme structure
        Object pointer = null;

        // iterating through all tags
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            // Refer from Example code from 
            // https://www.geeksforgeeks.org/stax-xml-parser-java/
        
            // This will trigger when the tag is of type <...> 
            if (event.isStartElement()) 
            { 
                StartElement element = (StartElement)event;
  
                // Checking which tag needs to be opened for reading. 
                // If the tag matches then the boolean of that tag 
                // is set to be true.
                if (element.getName().toString().equalsIgnoreCase("Scene")) 
                { 
                    System.out.println("Scene Created");
                    this.sceneEntities = new Group();
                    pointer = this.sceneEntities;
                } 
                if (element.getName().toString().equalsIgnoreCase("Group")) 
                { 
                    try {
                        Group g = (Group) pointer;
                        Group new_g = new Group();
                        new_g.parent = g;
                        g.addChild(new_g);
                        pointer = new_g;
                        System.out.println("Group Created");
                    } catch (Exception e) {
                        System.out.println("Created Group failed");
                    }
                } 
                if (element.getName().toString().equalsIgnoreCase("Transform")) 
                { 
                    try {
                        Group g = (Group) pointer;
                        Transform t = new Transform();
                        String value = this.getAttribute (element)[0];
                        t.parent = g;
                        t.translation = new Vec3D(value);
                        g.addChild(t);
                        pointer = t;
                        System.out.println("Tranform Node Created :" + t.translation.toString());
                    } catch (Exception e) {
                        System.out.println("Created Tranform Node failed");
                    }
                } 
                if (element.getName().toString().equalsIgnoreCase("Shape")) 
                { 
                    try {
                        Transform t = (Transform) pointer;
                        Shape s = new Shape();
                        s.parent = t;
                        t.shape = s;
                        pointer = s;
                        System.out.println("Shape Created");
                    } catch (Exception e) {
                        System.out.println("Created Shape failed");
                    }
                } 
                if (element.getName().toString().equalsIgnoreCase("Sphere")) 
                { 
                    try {
                        Shape s = (Shape) pointer;
                        Vec3D centre = s.parent.translation;
                        String value = this.getAttribute (element)[0];
                        double radius = Double.parseDouble(value);
                        Sphere sphere = new Sphere(radius, centre);
                        sphere.parent = s;
                        s.geometry = sphere;
                        pointer = sphere;
                        System.out.println("Sphere Created: radius " + sphere.radius + " centre: " + sphere.center.toString());
                    } catch (Exception e) {
                        System.out.println("Created Sphere failed");
                    }
                } 
                if (element.getName().toString().equalsIgnoreCase("Cone")) 
                { 
                    try {
                        Shape s = (Shape) pointer;
                        Vec3D apex = s.parent.translation;
                        String[] value = this.getAttribute (element);
                        double radius = Double.parseDouble(value[0]);
                        double height = Double.parseDouble(value[1]);
                        Cone cone = new Cone(apex, radius, height);
                        cone.parent = s;
                        s.geometry = cone;
                        pointer = cone;
                        System.out.println("Cone Created: apex " + cone.apex.toString() + " radius: " + cone.radius + " height: " + cone.height);
                    } catch (Exception e) {
                        System.out.println("Created Cone failed");
                    }
                } 
                if (element.getName().toString().equalsIgnoreCase("Plane")) 
                { 
                    System.out.println("Plane Created");
                } 
                if (element.getName().toString().equalsIgnoreCase("Appearance")) 
                { 
                    try {
                        Shape s = (Shape) pointer;
                        Appearance a = new Appearance();
                        a.parent = s;
                        s.appearance = a;
                        pointer = a;
                        System.out.println("Apperance Created");
                    } catch (Exception e) {
                        System.out.println("Created Apperance failed");
                    }
                } 
                if (element.getName().toString().equalsIgnoreCase("Material")) 
                { 
                    try {
                        Appearance a = (Appearance) pointer;
                        String[] value = this.getAttribute (element);
                        Vec3D diffuseColor = new Vec3D(value[0]);
                        Material m = new Material(diffuseColor);
                        m.parent = a;
                        a.material = m;
                        pointer = m;
                        System.out.println("Material Created: Diffuse Color = " + m.diffuseColor.toString());
                    } catch (Exception e) {
                        System.out.println("Created Material failed");
                    }
                }
                
            } 
  
            // This will be triggered when the tag is of type </...> 
            if (event.isEndElement()) 
            { 
                EndElement element = (EndElement) event; 
  
                // Checking which tag needs to be closed after reading. 
                // If the tag matches then the boolean of that tag is 
                // set to be false. 
                if (element.getName().toString().equalsIgnoreCase("Group")) 
                { 
                    try {
                        Group g = (Group) pointer;
                        pointer = g.parent;
                        System.out.println("Return to Scene");
                    } catch (Exception e) {
                        System.out.println("Exit Group failed");
                    }   
                } 
                if (element.getName().toString().equalsIgnoreCase("Transform")) 
                { 
                    try {
                        Transform t = (Transform) pointer;
                        pointer = t.parent;
                        System.out.println("Return to Group");
                    } catch (Exception e) {
                        System.out.println("Exit Transform failed");
                    }  
                } 
                if (element.getName().toString().equalsIgnoreCase("Shape")) 
                { 
                    try {
                        Shape s = (Shape) pointer;
                        pointer = s.parent;
                        System.out.println("Return to Transform");
                    } catch (Exception e) {
                        System.out.println("Exit Shape failed");
                    }
                } 
                if (element.getName().toString().equalsIgnoreCase("Sphere") | element.getName().toString().equalsIgnoreCase("Cone") | element.getName().toString().equalsIgnoreCase("Plane")) 
                { 
                    try {
                        Geometry g =  (Geometry) pointer;
                        pointer = g.parent;
                        System.out.println("Return to Shape");
                    } catch (Exception e) {
                        System.out.println("Exit Geometry failed");
                    }
                } 

                if (element.getName().toString().equalsIgnoreCase("Appearance")) 
                { 
                    try {
                        Appearance a =  (Appearance) pointer;
                        pointer = a.parent;
                        System.out.println("Return to Shape");
                    } catch (Exception e) {
                        System.out.println("Exit Appearance failed");
                    }
                } 
                if (element.getName().toString().equalsIgnoreCase("Material")) 
                { 
                    try {
                        Material m =  (Material) pointer;
                        pointer = m.parent;
                        System.out.println("Return to Appearance");
                    } catch (Exception e) {
                        System.out.println("Exit Material failed");
                    }
                } 
            } 
        }
    }

    private String[] getAttribute (StartElement element){
        // Iterator for accessing the metadeta related 
                // the tag started. 
                // Here, it would name of the Element 
                Iterator<Attribute> iterator = element.getAttributes();
                ArrayList<String> value = new ArrayList<String>(); 
                while (iterator.hasNext()) 
                { 
                    Attribute attribute = iterator.next(); 
                    QName name = attribute.getName(); 
                    value.add(attribute.getValue());
                    // Console print out
                    System.out.println(name+" = " + value); 
                }

                return value.toArray(new String[value.size()]);
    }
}
