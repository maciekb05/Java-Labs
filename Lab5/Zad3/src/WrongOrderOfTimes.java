public class WrongOrderOfTimes extends Exception {
    WrongOrderOfTimes(String message, Integer number) {
        super(message);
        System.out.print("Order of times are wrong at line " + number + ": ");
    }
}