package crossword.dictionary;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        try{
            InteliCwDB baza = new InteliCwDB("D:\\Studia\\Semestr III\\Programowanie obiektowe\\Zadanie\\src\\crossword\\dictionary\\fetch.txt");
            for(Entry i : baza.dict){
                System.out.println(i.getWord() + " - " + i.getClue());
            }
            System.out.println("Pattern");
            for(Entry i : baza.findAll("a...")){
                System.out.println(i.getWord() + " - " + i.getClue());
            }
        } catch (FileNotFoundException a){
            System.out.println("Plik nie został znaleziony");
        }
    }
}
