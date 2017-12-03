import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        while(true) {
            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                echoSocket = new Socket("glados.kis.agh.edu.pl", 3002);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(
                        echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host: localhost.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for "
                        + "the connection to: localhost.");
                System.exit(1);
            }

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;

            System.out.println("Type a message: ");
            userInput = stdIn.readLine();
            out.println(userInput);
            System.out.println(in.readLine());

        }
    }
}