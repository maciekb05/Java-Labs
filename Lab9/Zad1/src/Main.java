import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {
        PasswordChecker checker = new PasswordChecker();
        checker.readPasswords("./src/fetch.txt");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("192.168.0.1", 3002);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: szymon.ia.agh.edu.pl.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: szymon.ia.agh.edu.pl.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        System.out.println("Type a message: ");
        out.println("");
        Integer len = Integer.parseInt(in.readLine());
        checker.deletePasswordsLen(len);
        System.out.println("echo: " + in.readLine());

        for (String pass : checker.getPasswords()) {
            System.out.println(pass);
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
