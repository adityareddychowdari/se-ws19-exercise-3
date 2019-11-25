package exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SphereTest {

    final static double DELTA = 0.00001;

    @Test
    public void SphereConstructorTest() {
        Sphere sphere = new Sphere(1.0, new Vec3D(2, 0, 0));
        assertEquals(sphere.radius, 1.0, DELTA);
        assertEquals(sphere.center, new Vec3D(2, 0, 0));
    }

    @Test
    public void SphereIntersectionTest1() {
        Sphere sphere = new Sphere(1.0, new Vec3D(2, 0, 0));
        Vec3D intersection = sphere.intersect(new Vec3D(1, 0, 0));
        assertEquals(intersection.x, 1.0, DELTA);
        assertEquals(intersection.y, 0.0, DELTA);
        assertEquals(intersection.z, 0.0, DELTA);
    }

    @Test
    public void SphereIntersectionTest2() {
        Sphere sphere = new Sphere(1.0, new Vec3D(2, 1, 0));
        Vec3D intersection = sphere.intersect(new Vec3D(1, 0, 0));
        assertEquals(intersection.x, 2.0, DELTA);
        assertEquals(intersection.y, 0.0, DELTA);
        assertEquals(intersection.z, 0.0, DELTA);
    }

    @Test
    public void SphereNoIntersectionTest() {
        Sphere sphere = new Sphere(1, new Vec3D(2, 2, 0));
        Vec3D intersection = sphere.intersect( new Vec3D(1, 0, 0));
        assertEquals(intersection, null);
    }
}
