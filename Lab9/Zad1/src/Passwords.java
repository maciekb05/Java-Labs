import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Passwords {
    private LinkedList<String> passwords;
    Passwords() throws Exception {
        passwords = new LinkedList<String>();
        File filePass = new File("./src/fetch.txt");
        FileReader fileReader = new FileReader(filePass);
        BufferedReader read = new BufferedReader(fileReader);
        String s;
        while((s = read.readLine()) != null) {
            passwords.add(s);
        }
    }
    public LinkedList<String> getPasswords() {
        return passwords;
    }
}
