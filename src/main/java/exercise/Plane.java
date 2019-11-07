package exercise;

public class Plane extends Geometry{

    public Vec3D origin;
    public Vec3D normal;

    public Plane(Vec3D origin, Vec3D normal){
        this.origin = origin;
        this.normal = normal;
    }

    @Override
    public Vec3D intersect(Vec3D other) {
        return null;
    }
}
