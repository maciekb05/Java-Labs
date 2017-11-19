package bielech.indicopicture;

import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class IndicoPictures {
    private Indico indico;
    private File[] listOfFiles;
    private String output = "./images/";

    public IndicoPictures() throws IndicoException{
        indico = new Indico("6b263e08f8ab745daa278136c7622a76");
    }
    public void loadFiles(String pathName) throws NotAnImage, NullPointerException, IOException {
        File folder = new File(pathName);
        listOfFiles = folder.listFiles();

        for(File file : listOfFiles) {
            String mimetype= URLConnection.guessContentTypeFromName(file.getName());
            String type = mimetype.split("/")[0];
            if(!type.equals("image")){
                throw new NotAnImage("Not an image file");
            }
        }
    }
    public void recognizeImages() throws IndicoException, IOException {
        Map<String, Object> parametry = new HashMap<String, Object>();
        parametry.put("hq", true);
        BatchIndicoResult multiple = indico.imageRecognition.predict(listOfFiles,parametry);
        List<Map<String, Double>> results = multiple.getImageRecognition();
        int index = 0;

        for (Map<String, Double> map : results) {
            Map.Entry<String, Double> maxEntry = null;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }
            if (maxEntry.getKey() != null) {
                new File(output + maxEntry.getKey()).mkdirs();
            }
            Files.copy(listOfFiles[index].toPath(), new File(output + maxEntry.getKey() + "/" + listOfFiles[index].getName()).toPath(), REPLACE_EXISTING);
            index++;
        }
        System.out.println("Done");
    }
    public LinkedHashMap<String, Double> recognizeImage(File file) throws IOException, IndicoException {
        Map<String, Object> parametry = new HashMap<String, Object>();
        parametry.put("top_n", 5);
        parametry.put("hq", true);
        IndicoResult multiple = indico.imageRecognition.predict(file, parametry);
        Map<String, Double> results = multiple.getImageRecognition();

        //Sorting map in reverse order
        LinkedHashMap<String, Double> resultOrdered = results.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        //Sorting reverse order to proper order
        List<String> keyList = new ArrayList<>(resultOrdered.keySet());
        LinkedHashMap<String, Double> result = new LinkedHashMap<>();
        for ( int i = keyList.size() - 1 ; i >= 0 ; i-- )
            result.put(keyList.get(i),resultOrdered.get(keyList.get(i)));

        return result;
    }

    public File[] getListOfFiles() {
        return listOfFiles;
    }
}
