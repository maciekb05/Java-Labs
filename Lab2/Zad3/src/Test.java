import java.util.LinkedList;
import java.util.Scanner;

public class Test {
    static LinkedList<Punkt3D> punkty;
    private static void wczytaj(){
        Punkt3D pkt = new Punkt3D(0,0,0);
        System.out.println("Podaj współrzędne x, y, z: ");
        Scanner in = new Scanner(System.in);
        pkt.setX(in.nextDouble());
        pkt.setY(in.nextDouble());
        pkt.setZ(in.nextDouble());
        punkty.add(pkt);
    }
    private static void wyswietl(){
        int j = 1;
        for (Punkt3D i:punkty) {
            System.out.print("Punkt " + j + ": ");
            System.out.println("x = " + i.getX() + ", y = " + i.getY() + ", z = " + i.getZ());
            ++j;
        }
    }
    private static void oblicz(){
        int x, y;
        System.out.println("Proszę wybrać dwa punkty: ");
        wyswietl();
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        System.out.println("Odleglosc miedzy punktem "+x+", a "+y+" wynosi: "+punkty.get(x-1).distance(punkty.get(y-1)));
    }
    public static void main(String[] args){
        punkty = new LinkedList<Punkt3D>();
        boolean end = false;
        while(true){
            if(end) { break; }
            int x;
            Scanner in = new Scanner(System.in);
            System.out.println("1. Wczytaj punkt 3D");
            System.out.println("2. Wyświetl wszystkie punkty");
            System.out.println("3. Oblicz odległość");
            System.out.println("4. Zakończ");
            x = in.nextInt();
            switch(x){
                case 1:
                    wczytaj();
                    break;
                case 2:
                    wyswietl();
                    break;
                case 3:
                    oblicz();
                    break;
                case 4:
                    end = true;
                    break;
                default:
                    System.out.println("Zły znak");
                    break;
            }
        }
    }
}
