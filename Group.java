package exercise;
import java.util.ArrayList;

public class Group extends Transform {

    public final Vec3D scale = new Vec3D(1, 1, 1);
    public final Vec3D translation = new Vec3D(0, 0, 0);
    public Transform parent;

    protected ArrayList<Transform> children = new ArrayList<Transform>();

    public void addChild(Transform t){
        this.children.add(t);
    }
}
