package crossword.dictionary;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class CwDB {
    protected LinkedList<Entry> dict;

    public CwDB(String filename) throws FileNotFoundException{
        dict = new LinkedList<Entry>();
        createDB(filename);
    }
    public void add(String word, String clue){
        dict.add(new Entry(word, clue));
    }
    public Entry get(String word){
        for(Entry i : dict){
            if(i.getWord().equals(word)){
                return i;
            }
        }
        return new Entry(null, null);
    }
    public void remove(String word){
        dict.remove(get(word));
    }
    public void saveDB(String filename) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(filename);
        for(Entry i : dict){
            out.println(i.getWord());
            out.println(i.getClue());
        }
    }
    public int getSize(){
        return dict.size();
    }
    protected void createDB(String filename) throws FileNotFoundException{
        String word;
        String clue;
        File file = new File(filename);
        Scanner in = new Scanner(file);
        while(true){
            if(in.hasNextLine()){
                word = in.nextLine();
            }
            else{
                break;
            }
            if(in.hasNextLine()){
                clue = in.nextLine();
                add(word, clue);
            }
            else{
                break;
            }
        }
    }
}
