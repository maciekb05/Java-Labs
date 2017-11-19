public class Main {
    public static void main(String[] args){
        Matrix a = new Matrix();
        Matrix b = new Matrix();

        System.out.println("A+B");
        Matrix c = a.add(b);
        c.printMatrix();
        System.out.println();

        System.out.println("A-B");
        c = a.sub(b);
        c.printMatrix();
        System.out.println();

        System.out.println("A*B");
        c = a.mul(b);
        c.printMatrix();
        System.out.println();
    }
}
