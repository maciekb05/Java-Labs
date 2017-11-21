import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        MyDB myDB = new MyDB();
        Boolean working = true;
        while(working) {
            System.out.println("Wybierz co chcesz robic");
            System.out.println("1. Dodaj do bazy");
            System.out.println("2. Wypisz wszystko");
            System.out.println("3. Wypisz danego autora");
            System.out.println("4. Wypisz dany nr ISBN");
            System.out.println("5. Usun ksiązki autora");
            System.out.println("6. Usun ksiązki ISBN");
            System.out.println("7. Wyjdz");
            Scanner in = new Scanner(System.in);
            try {
                Scanner in2 = new Scanner(System.in);
                switch(in.nextInt()){
                    case 1:
                        System.out.println("Podaj isbn, title, author, year");
                        myDB.addBook(in2.nextLine(),in2.nextLine(),in2.nextLine(),Integer.parseInt(in2.nextLine()));
                        break;
                    case 2:
                        myDB.selectBooks();
                        break;
                    case 3:
                        System.out.println("Podaj author");
                        myDB.selectBooksAuthor(in2.nextLine());
                        break;
                    case 4:
                        System.out.println("Podaj isbn");
                        myDB.selectBooksISBN(in2.nextLine());
                        break;
                    case 5:
                        System.out.println("Podaj author");
                        myDB.deleteBooksAuthor(in2.nextLine());
                        break;
                    case 6:
                        System.out.println("Podaj isbn");
                        myDB.deleteBooksISBN(in2.nextLine());
                        break;
                    case 7:
                        working = false;
                        break;
                }
            } catch(Exception e) {
                throw e;
            }
        }
    }
}
