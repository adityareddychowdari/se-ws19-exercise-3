package exercise;

public class Cone extends Geometry {

    /*
     * Top point of the cone.
     */
    public Vec3D apex;

    /*
     * Orientation of the cone. Goes from apex to the surface.
     */
    public Vec3D axis;

    public double radius;
    public double height;

    private final static Vec3D DEFAULT_AXIS = new Vec3D(0.0, -1.0, 0.0);

    /*
     * Create a new cone with default axis (0, -1, 0).
     */
    public Cone(Vec3D apex, double radius, double height){
        this.apex = apex;
        this.axis = DEFAULT_AXIS;
        this.radius = radius;
        this.height = height;
    }

    public Cone(Vec3D apex, Vec3D axis, double radius, double height){
        this.apex = apex;
        this.axis = axis;
        this.radius = radius;
        this.height = height;
    }

    @Override
    public Vec3D intersect(Ray ray) {
        // http://lousodrome.net/blog/light/2017/01/03/intersection-of-a-ray-and-a-cone/

        double slantHeight = Math.sqrt(this.height * this.height + this.radius * this.radius);
        double angle = 2 * Math.asin(this.radius / slantHeight);

        Vec3D d = ray.direction.normalize();
        Vec3D o = ray.origin;
        Vec3D co = o.sub(apex);

        double dv = d.dot(this.axis);
        double csq = Math.cos(angle) * Math.cos(angle);
        double cov = co.dot(this.axis);

        double a = dv * dv - csq;
        double b = 2.0 * (dv * cov - d.dot(co) * csq);
        double c = cov * cov - co.dot(co) * csq;
        double delta = b * b - 4.0 * a *c;
        if (delta < 0.0) {
            return null;
        }

        // alternative solution: -b - ... = back shell
        double t = (-b + Math.sqrt(delta)) / (2.0 * a);
        Vec3D p = d.mul((float)t);

        Vec3D dist = p.sub(apex);
        if (dist.len() > height) {
            return null;
        }

        if (dist.dot(axis) < 0) {
            return null;
        }

        return p;

    }
}
