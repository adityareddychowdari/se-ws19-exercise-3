package exercise;

public class Cone extends Geometry {

    public Vec3D apex;
    public double radius;
    public double height;

    public Cone(Vec3D apex, double radius, double height){
        this.apex = apex;
        this.radius = radius;
        this.height = height;
    }

    @Override
    public Vec3D intersect(Vec3D ray) {
        // http://lousodrome.net/blog/light/2017/01/03/intersection-of-a-ray-and-a-cone/

        double slantHeight = Math.sqrt(this.height * this.height + this.radius * this.radius);
        double angle = 2 * Math.asin(this.radius / slantHeight);

        Vec3D d = ray.normalize();
        Vec3D o = new Vec3D(0, 0, 0);
        Vec3D co = o.sub(apex);

        // We just assume a fixed orientation for all the cones here
        Vec3D axis = new Vec3D(0, 0, -1);

        double dv = d.dot(axis);
        double csq = Math.cos(angle) * Math.cos(angle);
        double cov = co.dot(axis);

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
