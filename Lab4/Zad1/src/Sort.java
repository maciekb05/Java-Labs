import java.util.Collections;
import java.util.LinkedList;

public class Sort {
    public static void sort(LinkedList<Worker> workers) {
        Collections.sort(workers, new Compare());
    }
}
