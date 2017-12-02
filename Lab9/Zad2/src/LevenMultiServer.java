import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

public class LevenMultiServer {
    public static void main(String[] args) {
        int portNumber = 3002;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                new LevenMultiServerThread(serverSocket.accept()).start();
            }
        } catch(SocketException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
