import java.io.IOException;

public class TestLeven {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String distances = "";
        PasswordChecker checker = new PasswordChecker();
        checker.readPasswords("./src/fetch.txt");
        String pass = "ABDYKOWAC";

        Integer max = 0;
        for(int i = 0; i < alphabet.length(); ++i) {
            Integer distance = Levenshtein.levenshtein(alphabet.substring(i,i+1), pass); //Symulacja działania serwera
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

        Integer min = 2*max;
        String found = "";
        Integer distance = 2*max;
        for(int i = 0; i<checker.getPasswords().size(); i++) {
            distance = Levenshtein.levenshtein(checker.getPasswords().get(i),pass);
            if(distance == 0) {
                System.out.println("Hasło to: "+checker.getPasswords().get(i));
            }
            else if(distance < min) {
                found = checker.getPasswords().get(i);
                System.out.println("Znaleziono lepsze dopasowanie: "+found+" distance="+distance);
                System.out.println(found);
            }
        }
        System.out.println("Jesli wszystko poszło dobrze, to haslo to: "+found+" musisz jedynie zmienic wielkosc "+distance+" znaków");
    }
}