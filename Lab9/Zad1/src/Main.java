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

        while(true) {
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

            String query;
            String firstPass = checker.getPasswords().getFirst();
            query = "LOGIN szymon;" + firstPass;
            System.out.println(query);
            out.println(query);
            Integer distance = Integer.parseInt(in.readLine());
            System.out.println(distance);
            checker.deletePasswordsLev(firstPass, distance);

            out.close();
            in.close();
            echoSocket.close();
        }
    }
}
