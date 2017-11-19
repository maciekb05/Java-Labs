public class Main {
    public static void main(String[] args) {
        String inFile = "in.txt";
        String outFile = "out.txt";
        try{
            Subtitles.delay(inFile, outFile, 3, 30);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
