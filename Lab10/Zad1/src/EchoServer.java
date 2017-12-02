import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
    public static void main(String[] args) {
        int portNumber = 3002;

        try {
            //Creating a serverSocket
            ServerSocket serverSocket = new ServerSocket(portNumber);
            //Accepting client socket
            Socket clientSocket = serverSocket.accept();
            //Creating PrintWriter to send data to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            //Creating BufferedReader to get data from client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("echo: " + inputLine);
            }
        } catch (SocketException ex) {
            System.out.println("Wysłano żądanie zakończenia");
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
