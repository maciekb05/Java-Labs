import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LevenMultiThreadPoolServerThread extends Thread {
    private Socket socket;
    private String password = "LwoWianIn";

    LevenMultiThreadPoolServerThread(Socket socket) {
        super("EchoMultiServerThread");
        this.socket = socket;
    }

    public void run() {
        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String inputLine, outputLine;
            Integer output;

            inputLine = in.readLine();
            inputLine = inputLine.substring(13,inputLine.length());
            System.out.println(inputLine);
            sleep(400);
            output = Levenshtein.levenshtein(inputLine, password);
            if(output == 0) {
                outputLine = "ab132ndb89";
            }
            else {
                outputLine = output.toString();
            }
            out.println(outputLine);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
