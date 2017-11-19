import java.io.*;

public class Cryptographer {
    static void cryptFile(String fileToCipher, String fileOutput, Algorithm algorithmToUse){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToCipher));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutput));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(algorithmToUse.crypt(line));
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    static void decryptFile(String fileToDecrypt, String fileOutput, Algorithm algorithmToUse){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToDecrypt));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutput));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(algorithmToUse.decrypt(line));
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
