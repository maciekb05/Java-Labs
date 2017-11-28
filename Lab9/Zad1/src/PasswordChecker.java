import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class PasswordChecker {
    LinkedList<String> passwords = new LinkedList<>();

    public void readPasswords(String filePath) throws FileNotFoundException {
        File pass = new File(filePath);
        Scanner inFile = new Scanner(pass);
        while(inFile.hasNextLine()) {
            passwords.add(inFile.nextLine());
        }
    }

    public void deletePasswordsLen(int len) {
        for(String pass : passwords) {
            if (pass.length() != len) {
                passwords.remove(pass);
            }
        }
    }

    public void deletePasswordsLev(String pierwszy, Integer distance) {
        for(String pass : passwords) {
            int dist = Levenshtein.levenshtein(pierwszy, pass);
            if (dist != distance) {
                passwords.remove(pass);
            }
        }
    }



    public LinkedList<String> getPasswords() {
        return passwords;
    }
}
