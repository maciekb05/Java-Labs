import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PasswordChecker {
    private LinkedList<String> passwords = new LinkedList<>();

    public void readPasswords(String filePath) throws FileNotFoundException {
        File pass = new File(filePath);
        Scanner inFile = new Scanner(pass);
        while(inFile.hasNextLine()) {
            String[] splitted = inFile.nextLine().split("/",2);
            String passwd = splitted[0];
            passwd = passwd.replace("ł", "l").replace("Ł", "L");
            passwd = passwd.replace("ę", "e").replace("Ę", "E");
            passwd = passwd.replace("ó", "o").replace("Ó", "O");
            passwd = passwd.replace("ą", "a").replace("Ą", "A");
            passwd = passwd.replace("ś", "s").replace("Ś", "S");
            passwd = passwd.replace("ł", "l").replace("Ł", "L");
            passwd = passwd.replace("ż", "z").replace("Ż", "Z");
            passwd = passwd.replace("ź", "z").replace("Ź", "Z");
            passwd = passwd.replace("ć", "c").replace("Ć", "C");
            passwd = passwd.replace("ń", "n").replace("Ń", "N");
            passwords.add(passwd);
        }
    }

    public void deletePasswordsLen(int len) {
        for (Iterator<String> iterator = passwords.iterator(); iterator.hasNext();) {
            String value = iterator.next();
            if (value.length() != len) {
                iterator.remove();
            }
        }
    }

    public void deletePasswordsLev(String pierwszy, Integer distance) {
        for (Iterator<String> iterator = passwords.iterator(); iterator.hasNext();) {
            String value = iterator.next();
            int dist = Levenshtein.levenshteinDistance(pierwszy, value);
            if (dist != distance) {
                iterator.remove();
            }
        }
    }

    public LinkedList<String> getPasswords() {
        return passwords;
    }
}
