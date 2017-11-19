public class Punkt3D extends Punkt2D {
    double z;
    Punkt3D(double x, double y, double z){
        super(x, y);
        this.z = z;
    }
    public void setZ(double z) {
        this.z = z;
    }
    public double getZ() {
        return z;
    }
    double distance(Punkt3D point){
        return Math.pow(Math.pow(x - point.x,2) + Math.pow(y - point.y,2) + Math.pow(z - point.z,2), 0.5);
    }
    public static void main(String[] args){
        Punkt3D p1 = new Punkt3D(5,3, 2);
        Punkt3D p2 = new Punkt3D(1,4,3);
        System.out.println(p1.distance(p2));
    }
}
