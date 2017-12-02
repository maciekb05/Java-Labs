import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class EchoClient {
    public static void main(String[] args) {
        String hostName = "localhost";
        int portNumber = 3002;
        //Try with resources
        try (
            //Creating a socket
            Socket echoSocket = new Socket(hostName, portNumber);
            //Creating PrintWriter to send data to socket
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            //Creating BufferedReader to get data from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            //Standard input BufferedReader
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println(in.readLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
