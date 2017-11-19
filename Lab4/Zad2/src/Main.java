import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("Podaj sciezki plikow wejsciowego i wyjsciowego w parametrach programu");
        }
        else{
            String inFileAddress = args[0];
            String outFileAddress = args[1];
            System.out.println("1. Szyfruj Rot");
            System.out.println("2. Deszyfruj Rot");
            System.out.println("3. Szyfruj Polibiusz");
            System.out.println("4. Deszyfruj Polibiusz");
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(rd);
            try{
                int choice = in.read();
                switch(choice-48){
                    case 1:
                        Cryptographer.cryptFile(inFileAddress,outFileAddress,new Rot());
                        System.out.println("Done");
                        break;
                    case 2:
                        Cryptographer.decryptFile(inFileAddress,outFileAddress,new Rot());
                        System.out.println("Done");
                        break;
                    case 3:
                        Cryptographer.cryptFile(inFileAddress,outFileAddress,new Polibiusz());
                        System.out.println("Done");
                        break;
                    case 4:
                        Cryptographer.decryptFile(inFileAddress,outFileAddress,new Polibiusz());
                        System.out.println("Done");
                        break;
                    default:
                        System.out.println("Something wrong :(");
                }


            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }

        }
    }
}
