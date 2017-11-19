package crossword.dictionary;

import java.util.LinkedList;

public class Test {
    static LinkedList<String> a = new LinkedList<String>();
    public static void main(String[] args){
        a.add("Agata");
        a.add(1, "agora");
        a.add(0, "dupa");
        System.out.println(a.get(0));
        System.out.println(a.get(1));
        System.out.println(a.get(2));
    }
}
