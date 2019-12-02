package exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConeTest {

    final static double DELTA = 0.00001;

    @Test
    public void ConeConstructorTest() {
        Cone cone = new Cone(new Vec3D(1, 1, 0), 1.0, 2.0);
        assertEquals(cone.apex, new Vec3D(1, 1, 0));
        assertEquals(cone.radius, 1.0, DELTA);
        assertEquals(cone.height, 2.0, DELTA);
    }

    @Test
    public void ConeIntersectionTest() {
        Cone cone = new Cone(new Vec3D(2.0, 2.0, 0.0), 2.0, 2.0);
        Ray ray = new Ray(new Vec3D(0.0, 0.0, 0.0), new Vec3D(2.0, 2.0, 0.0));
        Vec3D intersection = cone.intersect(ray);
        assertEquals(intersection.x, 2.0, DELTA);
        assertEquals(intersection.y, 2.0, DELTA);
        assertEquals(intersection.z, 0.0, DELTA);
    }

    @Test
    public void ConeNoIntersectionTest() {
        Cone cone = new Cone(new Vec3D(2.0, 2.0, 0.0), 2.0, 2.0);
        Ray ray = new Ray(new Vec3D(0.0, 0.0, 0.0), new Vec3D(0.0, 2.0, 0.0));
        Vec3D intersection = cone.intersect(ray);
        assertEquals(intersection, null);
    }

    @Test
    public void ConeIntersectionWithBaseTest() {
        Cone cone = new Cone(new Vec3D(3.0, 2.0, 0.0), 2.0, 2.0);
        Ray ray = new Ray(new Vec3D(0.0, 0.0, 0.0), new Vec3D(1.0, 0.0, 0.0));
        Vec3D intersection = cone.intersect(ray);

        assertEquals(intersection.x, 0.0, DELTA);
        assertEquals(intersection.y, 0.0, DELTA);
        assertEquals(intersection.z, 0.0, DELTA);
    }
}
