import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {

    private static String tryPassword(String query) {
        String answer = null;
        try (
                Socket echoSocket = new Socket("glados.kis.agh.edu.pl", 3002);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()))
                ) {
            out.println(query);
            answer = in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String distances = "";
        PasswordChecker checker = new PasswordChecker();
        checker.readPasswords("./src/fetch.txt");
        String foundPass = null;
        Integer foundDist = 0;

        Integer max = 0;
        for(int i = 0; i < alphabet.length(); ++i) {
            String query = "LOGIN szymon;" +  alphabet.substring(i,i+1);
            String answer = tryPassword(query);
            System.out.println(query);
            System.out.println(answer);
            Integer distance = Integer.parseInt(answer);
            distances += distance;
            if(distance > max) {
                max = distance;
            }
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
            String answer = tryPassword("LOGIN szymon;" +  checker.getPasswords().get(i));
            Integer distance = Integer.parseInt(answer);
            if(distance == 0) {
                System.out.println("Hasło to: "+checker.getPasswords().get(i));
            }
            else if(distance < min) {
                System.out.println("Znaleziono lepsze dopasowanie: "+checker.getPasswords().get(i)+" distance="+distance);
                foundPass = checker.getPasswords().get(i);
                foundDist = distance;
            }
        }
        System.out.println("Znaleziono najlepsze dopasowanie: "+foundPass+" musisz zmienić "+foundDist+" znaków na wielkie");
        String currentPassword = foundPass;
        currentPassword = currentPassword.toLowerCase();
        int distForPastPass;
        int distForCurrentPass = 0;
        Integer iterations = 0;

        while(true) {
            Integer levDist = 0;
            System.out.println(currentPassword);
            String returned = tryPassword("LOGIN szymon;" + currentPassword);
            if(returned.length()==10){
                System.out.println("ID: "+ returned);
                break;
            }
            try {
                System.out.println((levDist=Integer.parseInt(returned)));
            } catch (NumberFormatException ex) {
                System.out.println("Well Done!");
                System.out.println("Twoje ID: "+returned);
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
        }
    }
}
