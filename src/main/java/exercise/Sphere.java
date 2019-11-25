package exercise;

public class Sphere extends Geometry {

    public Vec3D center;
    public double radius;

    public Sphere(double radius, Vec3D center){
        this.radius = radius;
        this.center = center;
    }

    @Override
    public Vec3D intersect(Vec3D ray) {
        ray = ray.normalize();

        double d1 = this.center.dot(ray);
        double cl = this.center.len();
        double d2 = (d1 * d1) - (cl * cl) + (this.radius * this.radius);

        if (d2 < 0.0f) {
            return null;
        }

        double d = d1 - Math.sqrt(d2);
        return ray.mul(d);
    }
}
