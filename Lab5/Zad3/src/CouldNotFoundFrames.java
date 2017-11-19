public class CouldNotFoundFrames extends Exception {
    CouldNotFoundFrames(String message, Integer number) {
        super(message);
        System.out.print("Could not found times at line " + number + ": ");
    }
}