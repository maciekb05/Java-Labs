public class TestRot {
    public static void main(String[] args){
        Rot algorithm = new Rot();
        String word = "Ala ma KOTA, a kot ma Ale";
        System.out.println(algorithm.crypt(word));
        System.out.println(algorithm.decrypt(algorithm.crypt(word)));
    }
}
