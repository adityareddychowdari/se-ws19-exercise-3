package exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class X3dFileTest {
    final static String RESOURCE_PATH = "src/test/resources/";

    /* Test if the constructor loads the X3D file correctly. */
    @Test
    public void X3dFileConstructorTest() {
        X3dFile x3d = new X3dFile(RESOURCE_PATH + "test4.x3d");
    }
}
