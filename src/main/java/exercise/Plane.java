package exercise;

public class Plane extends Geometry {
    public Vec3D planePoint, normal;

    public Plane(Vec3D planePoint, Vec3D normal){
        this.planePoint = planePoint;
        this.normal = normal;
    }


    /**
     * This method evaluates an intersection point between an infinite plane and a ray.
     * Within the same coordinate space, the plane is described using the algebraic form
     * and the ray originates from the coordinate point [0, 0, 0], i.e., the origin.
     * If multiple intersection points exist, the intersection point closest to the
     * origin is returned. If no intersection exists, a null is returned.
     *
     * implementation base on:
     * https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection.
     *
     * @param ray This is a vector describing the rays' line of path (direction) from the origin.
     * @return Whats returned is the intersection point between the ray and the infinite plane closest to the origin.
     */
    @Override
    public Vec3D intersect(Vec3D ray) {
        // check if the ray is contained in the plane (case 1), or if there is no intersection (case 2)
        if (ray.dot(this.normal) == 0.0) {
            if (this.planePoint.sub(ray).dot(this.normal) == 0) {
                // If the ray lies on the plane (i.e., is contained by the plane)
                // the plane also intersects the ray at the origin and the closest
                // intersection point is thus the origin itself.
                return new Vec3D(0, 0, 0);
            } else {
                return null; // if there is no intersection a null is returned
            }
        } else {
            // compute the single point of intersection (case 3)
            double d = (this.planePoint.sub(ray)).dot(this.normal) / ray.dot(this.normal);
            return ray.mul(d).add(ray);
        }
    }
}

