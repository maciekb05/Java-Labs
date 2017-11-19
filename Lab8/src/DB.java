import java.sql.*;

public class DB{
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/bielech","bielech","0qoz6eZ86FAB2TYm");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }
    public void listBooks(String query) throws SQLException {
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println("ISBN: " + rs.getString(1) + " Tytuł: " + rs.getString(2) +
                    " Autor: " + rs.getString(3) + " Rok: " + rs.getString(4));
        }
    }
    public void deleteBookAuthor(String author) throws SQLException{
        stmt = conn.createStatement();
        stmt.executeUpdate(
                "DELETE FROM books WHERE author = \""+author+"\"");
    }
    public void deleteBookISBN(String isbn) throws SQLException{
        stmt = conn.createStatement();
        stmt.executeUpdate(
                "DELETE FROM books WHERE isbn = \""+isbn+"\"");
    }
    public void addBook(String isbn, String title, String author, Integer year)throws SQLException{
        stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO books VALUES ('"+ isbn +"','"+ title +"','"+ author +"',"+ year+")");
    }
}