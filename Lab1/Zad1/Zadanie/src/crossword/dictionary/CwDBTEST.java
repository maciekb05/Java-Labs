package crossword.dictionary;

import java.io.FileNotFoundException;

public class CwDBTEST {
    public static void main(String[] args) throws FileNotFoundException {
        CwDB dbase = new CwDB("D:\\Studia\\Semestr III\\Programowanie obiektowe\\Zadanie\\src\\crossword\\dictionary\\file.txt");
        dbase.add("dupa", "dupa");
        dbase.remove("dupa");
        for(Entry i : dbase.dict){
            System.out.println(i.getWord() + " - " + i.getClue());
        }
        System.out.println(dbase.get("dupa").getClue());
        System.out.println(dbase.getSize());
    }
}
