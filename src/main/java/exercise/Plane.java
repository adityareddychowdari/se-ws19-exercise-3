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
     * Implementation is based on https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection.
     * Since the ray always starts in the origin, we can use ray for both l and l_0 (we use the same
     * Vec3D datatype for points and vectors).
     * @param ray Line that starts at the camera position.
     * @return Intersection point of line and plane. If multiple intersection points exist, the the
     * closest to the camera position is returned. If no intersection exists, return null.
     */
    @Override
    public Vec3D intersect(Ray ray) {
        Vec3D direction = ray.direction.normalize();
        Vec3D rayOrigin = ray.origin;

        // Check if line and plane are parallel.
        if (direction.dot(this.normal) == 0.0) {
            if (this.planePoint.sub(direction).dot(this.normal) == 0) {
                // Line is on the plane. Since the ray starts in the camera position, we can always
                // return that.
                return ray.origin;
            } else {
                return null; // if there is no intersection a null is returned
            }
        } else {
            // Compute the intersection point.
            double d = (this.planePoint.sub(rayOrigin)).dot(this.normal) /
                direction.dot(this.normal);
            return direction.mul(d).add(rayOrigin);
        }
    }
}

