package exercise;

public class Plane extends Geometry{

    public Vec3D origin, normal;

    /* Intersection point/s lie in a triangle formed by three points on the plane:
     *
     *              planePointO, planePointA, and planePointB
     *
     * Where a line is described by all points that are a given direction from a point/origin:
     *
     *                      linePointA and linePointB
     */

    private Vec3D linePointA, linePointB;
    private Vec3D planePointO, planePointA, planePointB;
    private Vec3D lineVectorAB, planeVectorOA, planeVectorOB;


    public Plane(Vec3D origin, Vec3D normal){
        this.origin = origin;
        this.normal = normal;

        this.linePointA = new Vec3D(1, 1, 1);
        this.linePointB = new Vec3D(1, 1, 1);

        this.planePointO = new Vec3D(1, 1, 1);
        this.planePointA = new Vec3D(1, 1, 1);
        this.planePointB = new Vec3D(1, 1, 1);
    }


    private Vec3D noIntersection(){
        System.out.print("not sure what Im doing yet");
        return null;
    }


    private Vec3D pointIntersection(){
        System.out.print("not sure what Im doing yet");
        return null;
    }


    private Vec3D containedIntersection(){
        System.out.print("not sure what Im doing yet");
        return null;
    }


    /**
     *  Here we evaluate the determinant of the intersection:
     *  If the determinant is zero, then there is no unique
     *  solution; the line is either in the plane or parallel to it
     *
     *    - (lineVectorAB) • ((planeVectorOA) x (planeVectorOB))
     *
     *  @return a true or false indication of whether or not a
     *          unique solution exists
     */
    private boolean uniqueSolution(){
        lineVectorAB = linePointB.sub(linePointA);
        planeVectorOA = planePointA.sub(planePointO);
        planeVectorOB = planePointB.sub(planePointO);

        if((lineVectorAB.mul(-1)).mul(planeVectorOA.cross(planeVectorOB)) == 0){
            return false;
        }
        else
            return true;
    }

    @Override
    public Vec3D intersect(Vec3D other) {
        if(!uniqueSolution()){
           noIntersection();
           containedIntersection();
        }
        else
            pointIntersection();
        return null;
    }
}
