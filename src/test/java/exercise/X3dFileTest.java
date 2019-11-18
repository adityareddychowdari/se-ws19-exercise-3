package exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class X3dFileTest {
    final static String RESOURCE_PATH = "src/test/resources/";

    @Test
    public void X3dFileConstructorTest() {
        X3dFile x3d = new X3dFile(RESOURCE_PATH + "test3.x3d");
    }
}
