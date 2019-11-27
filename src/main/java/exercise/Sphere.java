package exercise;

public class Sphere extends Geometry {

    public Vec3D center;
    public double radius;

    public Sphere(double radius, Vec3D center){
        this.radius = radius;
        this.center = center;
    }

    /*
     * Return the intersection point of line and sphere.
     *
     * Original code by Thảo Nguyễn.
     *
     * @param Line starting at the origin (i.e. (0, 0, 0)).
     * @return Intersection point closest to the origin. If there exists no intersection, return
     * null.
     */
    @Override
    public Vec3D intersect(Ray ray) {
        Vec3D direction = ray.direction.normalize();

        // Equation from Wikipedia:
        // d = -(l·(o-c)) ± √((l·(o-c))ˆ2 - ||o - c||ˆ2 + rˆ2)
        double d;

        // Calculate the difference between the origin and the sphere's center point.
        Vec3D diff_o_c = ray.origin.sub(this.center);

        // Calculate the dot product of the ray vector and the difference (o - c).
        double dot_l_oc = direction.dot(diff_o_c);

        // Calculate the distance between the origin and the sphere's center point.
        double dist_o_c = diff_o_c.len();

        // Calculate the value under the square root, namely delta.
        double delta = Math.pow(dot_l_oc, 2) - Math.pow(dist_o_c, 2) + Math.pow(this.radius, 2);

        // Due to rounding error, delta only gets close to 0, when it should be 0.
        // Therefore the comparison "if (delta==0)" can be re-written as "if (|delta|<epsilon)"
        // where epsilon is an arbitrarily small positive quantity.
        double epsilon = 0.00001f;

        // The point(s) of intersection can be calculated using the following equation:
        // x = o + dl

        // If delta = 0, then the line touches the sphere only at one point (one solution).
        if (Math.abs(delta) < epsilon) {
            d = - dot_l_oc;
            return direction.mul(d);
        }

        // If delta < 0, then the line and the sphere do not intersect (no solution).
        else if (delta < 0) {
            return null;
        }

        // If delta > 0, then the line intersects the sphere at two points (two solutions).
        double d1 = -dot_l_oc + Math.sqrt(delta);
        double d2 = -dot_l_oc - Math.sqrt(delta);

        // Determine the smaller distance and return the point that is closer to the origin.
        d = Math.min(Math.abs(d1), Math.abs(d2));
        return direction.mul(d).add(ray.origin);
    }
}
