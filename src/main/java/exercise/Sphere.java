package exercise;

public class Sphere extends Geometry{

    public  Vec3D center;
    public  double radius;

    public Sphere(Double radius, Vec3D center){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Vec3D intersect(Vec3D ray) {
        return null;
    }
}
