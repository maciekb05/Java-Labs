import java.util.Arrays;
import java.util.LinkedList;

public class Polibiusz implements Algorithm {
    static final Integer[] a = {11,12,13,14,15,21,22,23,24,24,25,31,32,33,34,35,41,42,43,44,45,51,52,53,54,55};
    static final LinkedList<Integer> alphabet = new LinkedList<Integer>(Arrays.asList(a));

    public String crypt(String word){
        StringBuilder cryptedWord = new StringBuilder();
        Integer cryptedInt = 0;
        for(int i = 0; i < word.length(); ++i){
            if(word.charAt(i) >= 97 && word.charAt(i) <= 122){
                cryptedInt = alphabet.get(word.charAt(i)-97);

                cryptedWord.append(cryptedInt);
                cryptedWord.append(" ");
            }
            else if(word.charAt(i) >= 65 && word.charAt(i) <= 90){
                cryptedInt = alphabet.get(word.charAt(i)-65);

                cryptedWord.append(cryptedInt);
                cryptedWord.append(" ");
            }
        }
        return cryptedWord.toString();
    }
    public String decrypt(String word){
        String[] splited = word.split(" ");
        StringBuilder decryptedWord = new StringBuilder();
        for(int i = 0; i < splited.length; ++i){
            decryptedWord.append( (char)(alphabet.indexOf(Integer.parseInt(splited[i]))+97) );
        }
        return decryptedWord.toString();
    }
}
