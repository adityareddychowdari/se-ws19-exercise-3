package exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlaneTest {

   final static double DELTA = 0.00001;

    @Test
    public void PlaneConstructorTest() {
        Plane plane = new Plane(new Vec3D(2, 0, 0), new Vec3D(1, 0, 0));

        assertTrue(plane instanceof Geometry);
        assertEquals(plane.planePoint, new Vec3D(2, 0, 0));
        assertEquals(plane.normal, new Vec3D(1, 0, 0));
    }

    @Test
    public void PlaneIntersectionTest() {
         Plane plane = new Plane(new Vec3D(2, 0, 0), new Vec3D(1, 0, 0));
         Vec3D intersection = plane.intersect(new Vec3D(1, 1, 0));
         assertEquals(intersection.x, 2.0, DELTA);
         assertEquals(intersection.y, 2.0, DELTA);
         assertEquals(intersection.z, 0.0, DELTA);
    }

    @Test
    public void PlaneNoIntersectionTest() {
        Plane plane = new Plane(new Vec3D(2, 0, 0), new Vec3D(1, 0, 0));
        Vec3D intersection = plane.intersect(new Vec3D(0, 1, 0));
        assertEquals(intersection, null);
    }
}
