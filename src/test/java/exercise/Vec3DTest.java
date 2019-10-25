package exercise;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Vec3DTest {

    //allows precision loss
    final static double DELTA = 0.01;

    @Test
    public void Vec3DTestLen() {
        Vec3D v1 = new Vec3D(1, 0, 0);
        Vec3D v2 = new Vec3D(3, 0, 4);
        assertEquals(v1.len(), 1.0, DELTA);
        assertEquals(v2.len(), 5.0, DELTA);
    }

    @Test
    public void Vec3DTestCross1() {
        Vec3D v1 = new Vec3D(1, 1, 0);
        Vec3D v2 = new Vec3D(0, 1, 0);
        Vec3D v3 = v1.cross(v2);
        assertEquals(v3.x, 0.0, DELTA);
        assertEquals(v3.y, 0.0, DELTA);
        assertEquals(v3.z, 1.0, DELTA);
    }

    @Test
    public void Vec3DTestCross2() {
        Vec3D v1 = new Vec3D(1, 1, 0);
        Vec3D v2 = new Vec3D(0, 1, 0);
        Vec3D v3 = v2.cross(v1);
        assertEquals(v3.x,  0.0, DELTA);
        assertEquals(v3.y,  0.0, DELTA);
        assertEquals(v3.z, -1.0, DELTA);
    }

    @Test
    public void Vec3DTestNorm1() {
        Vec3D v1 = new Vec3D(1, 0, 0);
        assertEquals(1.0f, v1.norm().x, DELTA);
        assertEquals(0, v1.norm().y, DELTA);
        assertEquals(0, v1.norm().z, DELTA);
    }

    @Test
    public void Vec3DTestNorm2() {
        Vec3D v1 = new Vec3D(1, 1, 1);
        assertEquals(0.58f, v1.norm().x, DELTA);
        assertEquals(0.58f, v1.norm().y, DELTA);
        assertEquals(0.58f, v1.norm().z, DELTA);
    }

    @Test
    public void Vec3DTestNorm3() {
        Vec3D v1 = new Vec3D(3, 4, 5);
        assertEquals(0.42f, v1.norm().x, DELTA);
        assertEquals(0.57f, v1.norm().y, DELTA);
        assertEquals(0.71f, v1.norm().z, DELTA);
    }

}
