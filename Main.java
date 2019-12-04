package exercise;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /* n.b. gradle build implements a run task for running main */
        X3dFile x3d = new X3dFile("./src/test/resources/test4.x3d");
        Image image = new Image(640, 480);
        //image.trace(x3d.sceneEntities);
        //image.writePNG("test4.png");
    }
}

