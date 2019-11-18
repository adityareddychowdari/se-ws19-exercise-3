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
    public static void main(String[] args) throws IOException {
        X3dFile x3d = new X3dFile("src/test/resource/test4.xml");
        Image image = new Image(640, 480);
        image.trace(x3d.sceneEntities);
        image.writePNG("test4.ppm");
    }
}

