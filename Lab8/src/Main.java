import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try {
            DB db = new DB();
            db.connect();
            db.listBooks("SELECT * FROM books");
            System.out.println();
            db.listBooks("SELECT * FROM books WHERE author = \""+ "Fiodor Dostojewski" +"\"");
            System.out.println();
            db.listBooks("SELECT * FROM books WHERE isbn = \""+ "1234567891247" +"\"");
            System.out.println();
            db.deleteBookAuthor("Fiodor Dostojewski");
            db.deleteBookISBN("1234567891247");
            db.listBooks("SELECT * FROM books");
            System.out.println("Done");
            //db.addBook("1234567891235", "Komu bije dzwon", "Ernest Hemingway", 2008);
            //db.addBook("1234567891236", "Slonce tez wstaje", "Ernest Hemingway", 2008);
            db.addBook("1234567891238", "Bracia Karamazow", "Fiodor Dostojewski", 2008);
            db.addBook("1234567891239", "Zbrodnia i kara", "Fiodor Dostojewski", 2008);
            db.addBook("1234567891247", "Nowy wspanialy swiat", "Aldous Huxley", 2007);
            db.listBooks("SELECT * FROM books");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
