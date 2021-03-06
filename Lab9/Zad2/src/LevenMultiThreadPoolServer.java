import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LevenMultiThreadPoolServer {
    public static void main(String[] args) {
        int portNumber = 3002;
        ExecutorService exec = Executors.newFixedThreadPool(2);

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                exec.execute(new LevenMultiThreadPoolServerThread(serverSocket.accept()));
            }
        } catch(SocketException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
