import java.io.IOException;

public class TestLeven {
    public static void main(String[] args) throws IOException {
        PasswordChecker checker = new PasswordChecker();
        checker.readPasswords("./src/fetch.txt");
        String pass = "asc";
        while(true) {
            String query;
            String firstPass = checker.getPasswords().getFirst();
            query = "LOGIN szymon;" + firstPass;
            System.out.println(query);
            Integer distance = Levenshtein.levenshteinDistance(firstPass,pass); //Symulacja działania serwera
            System.out.println(distance);
            if(distance == 0) {
                break;
            }
            checker.deletePasswordsLev(firstPass, distance);
        }
    }
}