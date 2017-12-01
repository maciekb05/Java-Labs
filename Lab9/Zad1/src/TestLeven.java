import java.io.IOException;
import java.util.NoSuchElementException;

public class TestLeven {
    public static void main(String[] args) throws IOException {
        PasswordChecker checker = new PasswordChecker();
        checker.readPasswords("./src/fetch.txt");
        String pass = "ZyGFryd";
        while(true) {
            try {
                String query;
                String firstPass = checker.getPasswords().getFirst();
                query = "LOGIN szymon;" + firstPass;
                System.out.println(query);
                Integer distance = Levenshtein.levenshtein(firstPass, pass); //Symulacja działania serwera
                System.out.println(distance);
                if (distance == 0) {
                    break;
                }
                checker.deletePasswordsLev(firstPass, distance);
            } catch (NoSuchElementException ex) {
                System.out.println("KONIEC");
                break;
            }
        }
    }
}