import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

public class EchoMultiServer {
    public static void main(String[] args) {
        int portNumber = 3002;
        Boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new EchoMultiServerThread(serverSocket.accept()).start();
            }
        } catch(SocketException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
