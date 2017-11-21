import java.sql.SQLException;

public class MyDB {
    public void testAll() throws SQLException {
        int count = 0;
        int maxTries = 3;
        while (true) {
            try {
                DB db = new DB();
                db.connect();
                db.listBooks("SELECT * FROM books");
                System.out.println();
                db.listBooks("SELECT * FROM books WHERE author = \"" + "Fiodor Dostojewski" + "\"");
                System.out.println();
                db.listBooks("SELECT * FROM books WHERE isbn = \"" + "1234567891247" + "\"");
                System.out.println();
                db.deleteBookAuthor("Fiodor Dostojewski");
                db.deleteBookISBN("1234567891247");
                db.listBooks("SELECT * FROM books");
                System.out.println();
                db.addBook("1234567891238", "Bracia Karamazow", "Fiodor Dostojewski", 2008);
                db.addBook("1234567891239", "Zbrodnia i kara", "Fiodor Dostojewski", 2008);
                db.addBook("1234567891247", "Nowy wspanialy swiat", "Aldous Huxley", 2007);
                db.listBooks("SELECT * FROM books");
                break;
            } catch (Exception e) {
                System.out.println("This is try number: " + (count + 1));
                if (++count == maxTries) throw e;
            }
        }
    }
    public void selectBooks() throws SQLException{
        int count = 0;
        int maxTries = 3;
        while(true) {
            try {
                DB db = new DB();
                db.connect();
                db.listBooks("SELECT * FROM books");
                break;
            } catch(Exception e) {
                System.out.println("This is try number: "+(count+1));
                if (++count == maxTries) throw e;
            }
        }
    }
    public void selectBooksAuthor(String author) throws SQLException{
        int count = 0;
        int maxTries = 3;
        while(true) {
            try {
                DB db = new DB();
                db.connect();
                db.listBooks("SELECT * FROM books WHERE author LIKE \"%"+ author +"%\"");
                break;
            } catch(Exception e) {
                System.out.println("This is try number: "+(count+1));
                if (++count == maxTries) throw e;
            }
        }
    }
    public void selectBooksISBN(String isbn) throws SQLException{
        int count = 0;
        int maxTries = 3;
        while(true) {
            try {
                DB db = new DB();
                db.connect();
                db.listBooks("SELECT * FROM books WHERE isbn = \""+ isbn +"\"");
                break;
            } catch(Exception e) {
                System.out.println("This is try number: "+(count+1));
                if (++count == maxTries) throw e;
            }
        }
    }
    public void deleteBooksISBN(String isbn) throws SQLException{
        int count = 0;
        int maxTries = 3;
        while(true) {
            try {
                DB db = new DB();
                db.connect();
                db.deleteBookISBN(isbn);
                break;
            } catch(Exception e) {
                System.out.println("This is try number: "+(count+1));
                if (++count == maxTries) throw e;
            }
        }
    }
    public void deleteBooksAuthor(String author) throws SQLException{
        int count = 0;
        int maxTries = 3;
        while(true) {
            try {
                DB db = new DB();
                db.connect();
                db.deleteBookAuthor(author);
                break;
            } catch(Exception e) {
                System.out.println("This is try number: "+(count+1));
                if (++count == maxTries) throw e;
            }
        }
    }
    public void addBook(String isbn, String title, String author, Integer year) throws SQLException{
        int count = 0;
        int maxTries = 3;
        DB db = new DB();
        while(true) {
            try {
                db.connect();
                break;
            } catch(Exception e) {
                System.out.println("This is try number: "+(count+1));
                if (++count == maxTries) throw e;
            }
        }
        db.addBook(isbn, title, author, year);
    }

}
