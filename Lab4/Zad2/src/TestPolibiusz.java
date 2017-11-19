public class TestPolibiusz {
    public static void main(String[] args){
        Polibiusz algorithm = new Polibiusz();
        String word = "Ala ma KOTA, a kot ma Ale";
        System.out.println(algorithm.crypt(word));
        System.out.println(algorithm.decrypt(algorithm.crypt(word)));
    }
}
