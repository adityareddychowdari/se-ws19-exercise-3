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

        assertTrue(x3d.sceneEntities instanceof Group);

        Group group = x3d.sceneEntities;
        assertEquals(group.children.length, 2);

        assertTrue(group[0] instanceof Sphere);
        assertTrue(group[1] instanceof Cone);

        Sphere testSphere = new Sphere(new Vec3D(0.0, -1.0, 0.0), 2.3);
        Cone testCone = new Cone(4.0, 6.2);

        assertEquals(group[0], testSphere);
        assertEquals(group[1], testCone);
    }
}
