import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
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
//        for(String pass : passwords) {
//            if (pass.length() != len) {
//                passwords.remove(pass);
//            }
//        }
        for (Iterator<String> iterator = passwords.iterator(); iterator.hasNext();) {
            String value = iterator.next();
            if (value.length() != len) {
                iterator.remove();
            }
        }
    }

    public void deletePasswordsLev(String pierwszy, Integer distance) {
//        for(String pass : passwords) {
//            int dist = Levenshtein.levenshtein(pierwszy, pass);
//            if (dist != distance) {
//                passwords.remove(pass);
//            }
//        }
        for (Iterator<String> iterator = passwords.iterator(); iterator.hasNext();) {
            String value = iterator.next();
            int dist = Levenshtein.levenshtein(pierwszy, value);
            if (dist != distance) {
                iterator.remove();
            }
        }
    }

    public LinkedList<String> getPasswords() {
        return passwords;
    }
}
