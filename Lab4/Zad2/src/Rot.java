public class Rot implements Algorithm {
    private static final String alphabet = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
    //private static final String alphabet = "mMnNoOpPqQrRsStTuUvVwWxXyYzZ";
    static final int rotation = 11; //Must be between 1 and 26
    public String crypt(String word){
        StringBuilder cryptedWord = new StringBuilder(word.length());
        char cryptedCharacter;
        for(int i = 0; i < word.length(); ++i){
            if(alphabet.indexOf(word.charAt(i))!=-1){
                cryptedCharacter = alphabet.charAt((alphabet.indexOf(word.charAt(i))+(rotation*2))%alphabet.length());
                cryptedWord.append(cryptedCharacter);
            }
            else if(word.charAt(i)==' ') {
                cryptedWord.append(' ');
            }
            else {
                cryptedWord.append('#');
            }
        }
        return cryptedWord.toString();
    }
    public String decrypt(String word){
        StringBuilder decryptedWord = new StringBuilder(word.length());
        char decryptedCharacter;
        for(int i = 0; i < word.length(); ++i){
            if(alphabet.indexOf(word.charAt(i))!=-1){
                decryptedCharacter = alphabet.charAt((alphabet.indexOf(word.charAt(i))-(rotation*2)+alphabet.length())%alphabet.length());
                decryptedWord.append(decryptedCharacter);
            }
            else if(word.charAt(i)==' ') {
                decryptedWord.append(' ');
            }
            else {
                decryptedWord.append('#');
            }
        }
        return decryptedWord.toString();
    }
}
