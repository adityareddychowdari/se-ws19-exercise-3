package exercise;

public class Plane extends Geometry{
    public Vec3D planePoint, normal;

    public Plane(Vec3D planePoint, Vec3D normal){
        /* The constructor presupposes using the point-normal form
         * which employs any initial point on the plane and the plane
         * normal.
         */
        this.planePoint = planePoint;
        this.normal = normal;
    }


    /*
     * Return intersection of line and plane.
     *
     * Implementation is based on https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection.
     * Since the ray always starts in the origin, we can use ray for both l and l_0 (we use the same
     * Vec3D datatype for points and vectors).
     * @param ray Line that starts at origin.
     * @return Intersection point of line and plane. If multiple intersection points exist, the the
     * closest to the origin is returned. If no intersection exists, return null.
     */
    @Override
    public Vec3D intersect(Vec3D ray) {
        // Check if line and plane are parallel.
        if (ray.dot(this.normal) == 0.0) {
            if (this.planePoint.sub(ray).dot(this.normal) == 0) {
                // Line is on the plane. Since the ray starts in the origin, we can always return
                // that.
                return new Vec3D(0, 0, 0);
            } else {
                // The line is parallel to the plane, i.e. there is no intersection.
                return null;
            }
        } else {
            // Compute the intersection point.
            double d = (this.planePoint.sub(ray)).dot(this.normal) / ray.dot(this.normal);
            return ray.mul(d).add(ray);
        }
    }
}

