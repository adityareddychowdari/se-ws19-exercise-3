package exercise;

public class Plane extends Geometry{

    public Vec3D origin, normal;


    public Plane(Vec3D origin, Vec3D normal){
        this.origin = origin;
        this.normal = normal;
    }


    private Vec3D noIntersection(){
        System.out.print("returning null");
        return null;
    }


    private Vec3D containedIntersection(){
        System.out.print("returning the point closest to the origin");
        return null;
    }


    private Vec3D pointIntersection(Vec3D lineVec, Vec3D lp, Vec3D planeNormal, Vec3D pp){
        System.out.print("returning a single unique point");

        //todo: a convention for naming the points (readable code vs cluttered code)
            Vec3D diff = lp.sub(pp);
            double prod1 = diff.dot(planeNormal);
            double prod2 = lineVec.dot(planeNormal);
            double prod3 = prod1 / prod2;
            return lp.sub(lineVec.mul(prod3));
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
         * A line (ray) is described by points between a line origin (lo)
         * and a line point (denoted lp).
         *
         * --
         * Evaluating the determinant of the intersection:
         * If the determinant is zero, then there is no unique solution
         * i.e., the line is either in the plane or parallel to the plane.
         *
         *   (-1 x (lineVec)) • ((planeVec01) x (planeVec02))
         *
         * <ref: https://en.wikipedia.org/wiki/Line–plane_intersection>
         */

        Vec3D pp0, pp1, pp2, lo, lp;
        Vec3D lineVec, planeVec01, planeVec02;

        lo = new Vec3D(1, 1, 1);
        lp = new Vec3D(1, 1, 1);
        lineVec = lp.sub(lo);

        pp0 = new Vec3D(1, 1, 1);
        pp1 = new Vec3D(1, 1, 1);
        pp2 = new Vec3D(1, 1, 1);
        planeVec01 = pp1.sub(pp0);
        planeVec02 = pp2.sub(pp0);


        if((lineVec.mul(-1)).dot(planeVec01.cross(planeVec02)) == 0){
            return false;
        }
        else
            return true;
    }

    /**
     * intersect checks for a unique solution relating to a plane-line intersection.
     * If a unique intersection solution exists, the intersection point closest to
     * the origin is returned
     *
     * @return Vec3D point closest to the origin
     */
    @Override
    public Vec3D intersect(Vec3D other) {
        Vec3D point;

        if(!uniqueSolution()){
            // ... check if there is not intersection
            point = noIntersection();

            // ... only if there is a possible intersection
            point = containedIntersection();
        }
        else
            //point = pointIntersection();
        point = null;
        return point;
    }
}
