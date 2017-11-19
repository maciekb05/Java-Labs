import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void dodajDoListy(LinkedList<Shape> shapes){
        System.out.println("Co dodać ?");
        boolean working = true;
        Scanner in = new Scanner(System.in);
        while(working){
            int choice;
            System.out.println("1. Dodaj koło.");
            System.out.println("2. Dodaj prostokąt.");
            System.out.println("3. Dodaj kwadrat.");
            System.out.println("4. Zakończ dodawanie.");
            choice = in.nextInt();
            switch(choice){
                case 1:
                    shapes.add(new Circle("Koło"));
                    break;
                case 2:
                    shapes.add(new Rectangle("Prostokąt"));
                    break;
                case 3:
                    shapes.add(new Square("Kwadrat"));
                    break;
                case 4:
                    working = false;
                    break;
                default:
                    System.out.println("Niepoprawna liczba. Spróbuj jeszcze raz.");
            }
        }
    }
    public static void wyswietlListe(LinkedList<Shape> shapes) {
        for(Shape shape : shapes ){
            shape.draw();
        }
    }
    public static void main(String[] args){
        LinkedList<Shape> shapes = new LinkedList<Shape>();

        boolean working = true;
        Scanner in = new Scanner(System.in);
        while(working){
            int choice;
            System.out.println("1. Dodaj kształt/y do listy.");
            System.out.println("2. Wyświetl liste.");
            System.out.println("3. Zakończ.");
            choice = in.nextInt();
            switch(choice){
                case 1:
                    dodajDoListy(shapes);
                    break;
                case 2:
                    wyswietlListe(shapes);
                    break;
                case 3:
                    working = false;
                    break;
                default:
                    System.out.println("Niepoprawna liczba. Spróbuj jeszcze raz.");
            }
        }
    }
}
