import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String distances = "";
        PasswordChecker checker = new PasswordChecker();
        checker.readPasswords("./src/fetch.txt");

        Integer max = 0;
        for(int i = 0; i < alphabet.length(); ++i) {
            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                echoSocket = new Socket("galdos.kis.agh.edu.pl", 3002);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection.");
                System.exit(1);
            }

            out.println("LOGIN szymon;" +  alphabet.substring(i,i+1));
            Integer distance = Integer.parseInt(in.readLine());
            distances += distance;
            if(distance > max) {
                max = distance;
            }

            out.close();
            in.close();
            echoSocket.close();
        }
        checker.deletePasswordsLen(max);

        String letters = "";
        for(int i = 0; i < alphabet.length(); ++i) {
            if(Integer.parseInt(distances.substring(i,i+1)) < max) {
                letters += alphabet.substring(i,i+1);
            }
        }
        checker.deletePasswordsLetters(letters);

        Integer min = max;
        for(int i = 0; i<checker.getPasswords().size(); i++) {
            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                echoSocket = new Socket("galdos.kis.agh.edu.pl", 3002);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection.");
                System.exit(1);
            }

            out.println("LOGIN szymon;" +  checker.getPasswords().get(i));
            Integer distance = Integer.parseInt(in.readLine());
            if(distance == 0) {
                System.out.println("Hasło to: "+checker.getPasswords().get(i));
            }
            else if(distance < min) {
                System.out.println("Znaleziono lepsze dopasowanie: "+checker.getPasswords().get(i)+" distance="+distance);
                System.out.println(checker.getPasswords().get(i));
            }

            out.close();
            in.close();
            echoSocket.close();
        }
    }
}
