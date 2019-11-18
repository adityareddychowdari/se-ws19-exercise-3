package exercise;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException,  IOException {
        XMLParser parser = new PrettyPrintParser("./src/test/resources/test1.xml");
        parser.parse();

        Plane plane = new Plane(new Vec3D(1, 0, 0), new Vec3D(1, 0, 0));
        Vec3D intersectionPoint =  plane.intersect(new Vec3D(1, 0, 0));
        System.out.println(intersectionPoint.toString());

        X3dFile x3d = new X3dFile("src/test/resource/test3.xml");
        Image image = new Image(640, 480);
        image.trace(x3d.sceneEntities);
        image.writePNG("test3.ppm");
    }
}

