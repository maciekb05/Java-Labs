package crossword.dictionary;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InteliCwDB extends CwDB {
    public InteliCwDB(String filename) throws FileNotFoundException{
        super(filename);
    }
    public LinkedList<Entry> findAll(String pattern){
        LinkedList<Entry> out = new LinkedList<Entry>();
        Pattern p = Pattern.compile(pattern);
        Matcher m;
        for(Entry i : dict){
            m = p.matcher(i.getWord());
            if(m.matches()){
                out.add(i);
            }
        }
        return out;
    }
    public Entry getRandom(){
        Random rand = new Random();
        return dict.get(rand.nextInt(getSize()));
    }
    public Entry getRandom(int length){
        LinkedList<Entry> out = new LinkedList<Entry>();
        for(Entry i : dict){
            if(length == i.getWord().length()){
                out.add(i);
            }
        }
        Random rand = new Random();
        return out.get(rand.nextInt(out.size()));
    }
    public Entry getRandom(String pattern){
        LinkedList<Entry> out = new LinkedList<Entry>();
        Pattern p = Pattern.compile(pattern);
        Matcher m;
        for(Entry i : dict){
            m = p.matcher(i.getWord());
            if(m.matches()){
                out.add(i);
            }
        }
        Random rand = new Random();
        return out.get(rand.nextInt(out.size()));
    }
    public void add(String word, String clue){
            int loc = 0;
            for (int i = 0; i < dict.size(); i++) {
                if (word.compareToIgnoreCase(dict.get(i).getWord()) < 0) {
                    break;
                }
                loc++;
            }
            dict.add(loc,new Entry(word, clue));
    }
}
