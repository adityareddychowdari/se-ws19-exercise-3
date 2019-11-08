package exercise;

import java.io.FileNotFoundException;
import javax.xml.stream.XMLStreamException;

/**
 * The Main application creates a parser object
 * of type XMLParser, using the parse method to
 * parse any XML-type file.
 *
 * n.b. gradle build implements a run task which
 *      runs Main.class, displaying the results.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        // XMLParser parser = new PrettyPrintParser("./src/test/resources/test1.xml");
        // parser.parse();

        // lets test drive Plane.java
        Plane plane = new Plane(new Vec3D(1, 1, 1), new Vec3D(1, 1, 1));
        plane.intersect(new Vec3D(1, 1,1));
    }
}
