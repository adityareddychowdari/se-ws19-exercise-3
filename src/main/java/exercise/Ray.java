package exercise;

public class Ray {
    /*
     * Origin of the vector.
     */
    public Vec3D origin;
    public Vec3D direction;

    Ray(Vec3D origin, Vec3D direction) {
        this.origin = origin;
        this.direction = direction;
    }
}
