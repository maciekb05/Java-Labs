import java.io.IOException;

public class TestLeven {
    public static void main(String[] args) throws IOException {
        PasswordChecker checker = new PasswordChecker();
        checker.readPasswords("./src/fetch.txt");
        String password = "Łaba/M";
        checker.deletePasswordsLen(password.length());
        int distance = Levenshtein.levenshtein(checker.getPasswords().getFirst(), password);
        checker.deletePasswordsLev(checker.getPasswords().getFirst(), distance);
        for (String pass : checker.getPasswords()) {
            System.out.println(pass);
        }
    }
}