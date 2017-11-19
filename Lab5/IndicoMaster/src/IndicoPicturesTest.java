import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;

public class IndicoPicturesTest {
    public static void main(String[] args) {
        try {
            IndicoPictures indicoPictures = new IndicoPictures();
            indicoPictures.loadFiles("./foto/");
            indicoPictures.recognizeImages();
            LinkedHashMap<String, Double> probabilities = indicoPictures.recognizeImage(new File("./foto/tesla.jpg"));
            for(Map.Entry<String, Double> entry : probabilities.entrySet()){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }

        } catch (NotAnImage ex) {
            System.out.println("Not every one file is a image");
            System.out.println(ex.getMessage());
        } catch (IndicoException ex) {
            System.out.println(ex.getMessage());
        } catch (UnknownHostException ex) {
            System.out.println("There is no internet");
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Input/Output exception");
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Null pointer exception");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
