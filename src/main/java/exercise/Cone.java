package exercise;

public class Cone extends exercise.Geometry {

    public double radius;
    public double height;

    public Cone(Double radius, Double height){
        this.radius = radius;
        this.height = height;
    }

    @Override
    public Vec3D intersect(Vec3D other) {
        return null;
    }
}
