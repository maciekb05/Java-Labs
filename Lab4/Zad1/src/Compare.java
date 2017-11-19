import java.util.Comparator;

public class Compare implements Comparator<Worker> {
    public int compare(Worker o1, Worker o2) {
        if( o1.equals(o2) ) return 0;
        else if( o1.getWynagrodzenieBrutto() > o2.getWynagrodzenieBrutto() ) return 1;
        else return -1;
    }
}
