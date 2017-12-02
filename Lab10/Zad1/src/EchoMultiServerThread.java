import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoMultiServerThread extends Thread {
    private Socket socket = null;

    public EchoMultiServerThread(Socket socket) {
        super("EchoMultiServerThread");
        this.socket = socket;
    }

    public void run() {

        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                try{sleep(1000);} catch (InterruptedException ex) {};
                outputLine = "echo: " + inputLine;
                out.println(outputLine);
                if (outputLine.equals("Bye"))
                    break;
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
