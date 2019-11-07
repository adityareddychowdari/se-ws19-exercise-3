package exercise;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EntityTest {


    @Test
    public void ConeEntityTest() throws Exception {
        Cone cone = new Cone(0.0, 0.0);
        assertTrue(cone instanceof Geometry);
        assertThat(cone.height, is(0.0));
        assertThat(cone.radius, is(0.0));
    }

    @Test
    public void AppearanceEntityTest() throws Exception {
        Appearance appearance = new Appearance();
        assertTrue(appearance instanceof Appearance);
    }

    @Test
    public void GroupEntityTest() throws Exception {
        Group group = new Group();

        final Vec3D scale = new Vec3D(1, 1, 1);
        final Vec3D translation = new Vec3D(0, 0, 0);

        assertTrue(group instanceof Transform);
        assertEquals(group.scale.toString(), scale.toString());
        assertEquals(group.translation.toString(), translation.toString());
    }

    @Test
    public void MaterialEntityTest() throws Exception {
        Material material = new Material(new Vec3D(1, 2, 3));

        assertEquals(material.diffuseColor.toString(), new Vec3D(1, 2, 3).toString());
        assertTrue(material instanceof Material);
    }

    @Test
    public void ShapeEntityTest() throws Exception {
        Shape shape;
        shape = new Shape();

        assertTrue(shape instanceof Shape);
    }

    @Test
    public void SphereEntityTest() throws Exception {
        Sphere sphere = new Sphere(1.0, new Vec3D(1, 0, 0));
        assertTrue(sphere instanceof Geometry);
        //assertEquals(sphere.radius, 1.0); < ---- deprecation bug
        assertEquals(sphere.center.toString(), new Vec3D(1, 0, 0).toString());

    }
}
