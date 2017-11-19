public class Punkt2D {
    double x;
    double y;
    Punkt2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    double distance(Punkt2D point){
        return Math.pow(Math.pow(x - point.x,2) + Math.pow(y - point.y,2), 0.5);
    }
    public static void main(String[] args){
        Punkt2D p1 = new Punkt2D(5,3);
        Punkt2D p2 = new Punkt2D(5,10);
        System.out.println(p1.distance(p2));
    }
}
