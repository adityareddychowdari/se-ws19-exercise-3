package exercise;

/**
 * Vec3D represents a 3-dimensional vector and
 * supports fundamental mathematical operations.
 */
public class Vec3D {

    public double x;
    public double y;
    public double z;

    public Vec3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Vec3D(String s) {
        String[] items = s.split("\\s+");
        x = Float.parseFloat(items[1]);
        y = Float.parseFloat(items[2]);
        z = Float.parseFloat(items[3]);
    }

    public String toString() {
        return "[ " + x + " " + y + " " + z + " ]";
    }


    /**
     * Add operation for 3D vectors
     *
     * @param other 3D vector of type Vec3D
     * @return sum vector of type Vec3D
     */
    public Vec3D add(Vec3D other) {
        return new Vec3D(x + other.x, y + other.y, z + other.z);
    }


    /**
     * subtraction operation for 3D vectors
     *
     * @param other 3D vector of type Vec3D
     * @return difference vector of type Vec3D
     */
    public Vec3D sub(Vec3D other) {
        return new Vec3D(x - other.x, y - other.y, z - other.z);
    }


    /**
     * multiplication (scalar) operation for 3D vectors
     *
     * @param other 3D vector of type Vec3D
     * @return resultant vector of type Vec3D
     */
    public Vec3D mul(double other) {
        return new Vec3D(x * other, y * other, z * other);
    }


    /**
     * dot product operation for 3D vectors
     *
     * @param other 3D vector of type Vec3D
     * @return resultant double
     */
    public double dot(Vec3D other) {
        return x * other.x + y * other.y + z * other.z;
    }


    /**
     * magnitude evaluation of a 3D vector (L2 norm)
     *
     * @return magnitude of type double
     */
    public double len() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }


    /**
     * cross product of two 3D vectors:
     *
     * n.b. The cross product of two 3D vectors is the
     *      determinant of the corresponding 3 x 3 matrix.
     *
     * @param other 3D vector of type Vec3D
     * @return resultant vector of type Vec3D
     */
    public Vec3D cross(Vec3D other) {
        double xDeterminant = (y * other.z) - (z * other.y);
        double yDeterminant = - ((x * other.z) - (z * other.x));
        double zDeterminant = (x * other.y) - (y * other.x);
        return new Vec3D(xDeterminant, yDeterminant, zDeterminant);
    }


    /**
     * Normalizing a vector
     *
     * @return normalized vector
     */
    public Vec3D normalize() {
        return this.mul(1.0f / this.len());
    }
}

