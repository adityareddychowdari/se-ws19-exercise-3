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


    /**
     * intersect checks if a provided ray point exists on a given plane,
     * i.e., if a ray-plane intersection exists. If an intersection exists
     * the intersection point closest to the origin is returned.
     *
     * @return Vec3D point closest to the origin
     */
    @Override
    public Vec3D intersect(Vec3D rayPoint) {
        /* The point-normal form equation is used to evaluate if the
         * the ray intersects the plane, i.e., if the ray point lies
         * on the plane and is orthogonal to the normal
         *
         *        normal • ( planePoint - rayPoint ) = 0
         *
         * ref: <http://thejuniverse.org/PUBLIC/LinearAlgebra/LOLA/planes/pn.html>
         */
        if (normal.dot(rayPoint.sub(planePoint)) == 0.0){
            return rayPoint;
        }
        return null;
    }
}

