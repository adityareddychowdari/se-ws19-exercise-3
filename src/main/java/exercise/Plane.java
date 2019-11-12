package exercise;

public class Plane extends Geometry{

    public Vec3D origin, normal;


    public Plane(Vec3D origin, Vec3D normal){
        this.origin = origin;
        this.normal = normal;
    }


    private Vec3D noIntersection(){
        return null;
    }


    private Vec3D pointIntersection(){
        System.out.print("return a single unique point");
        return null;
    }


    private Vec3D containedIntersection(){
        System.out.print("return the point closest to the origin");
        return null;
    }


    /**
     * uniqueSolution provides an indication of whether or not a
     * unique solution exists.
     *
     *  @return a true or false indication
     */
    private boolean uniqueSolution(){

        /* Possible plane-line intersection points lie within a triangle formed by three
         * points on the plane; pp0, pp1, and pp2 (where a plane point is denoted by pp).
         *
         * --
         * A line is described by points between a line origin (lo) and a line end point
         * (denoted le).
         *
         * --
         * Evaluating the determinant of the intersection:
         * If the determinant is zero, then there is no unique
         * solution; the line is either in the plane or parallel to it
         *
         *   - (lineVec) • ((planeVec01) x (planeVec02))
         */
        Vec3D pp0, pp1, pp2, lo, le;
        Vec3D lineVec, planeVec01, planeVec02;

        lo = new Vec3D(1, 1, 1);
        le = new Vec3D(1, 1, 1);
        lineVec = le.sub(lo);

        pp0 = new Vec3D(1, 1, 1);
        pp1 = new Vec3D(1, 1, 1);
        pp2 = new Vec3D(1, 1, 1);
        planeVec01 = pp1.sub(pp0);
        planeVec02 = pp2.sub(pp0);


        if((lineVec.mul(-1)).mul(planeVec01.cross(planeVec02)) == 0){
            return false;
        }
        else
            return true;
    }

    /**
     * intersect checks for a unique solution relating to a plane-line intersection.
     * If an intersection exists, the intersection point closest to the origin is returned
     *
     * @return Vec3D point closest to the origin
     */
    @Override
    public Vec3D intersect(Vec3D other) {
        Vec3D point;

        if(!uniqueSolution()){
            point = noIntersection();
            point = containedIntersection();
        }
        else
            point = pointIntersection();
        return point;
    }
}
