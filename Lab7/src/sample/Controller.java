package sample;

import bielech.indicopicture.*;
import io.indico.api.utils.IndicoException;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class Controller {
    private String selectedPath;
    private LinkedHashMap<String, Double> listOfProbabilities;
    private IndicoPictures indicoPictures;
    @FXML
    Button browseButton;
    @FXML
    ListView<String> listView;
    @FXML
    BarChart<String, Double> barChart;
    @FXML
    ImageView imageView;
    public void initialize() {
        listenForListViewChanges();
    }

    public void browseButtonClicked() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(Paths.get(".").toAbsolutePath().normalize().toFile());
        File selectedDirectory = directoryChooser.showDialog(new Stage());
        if(selectedDirectory == null){
            System.out.println("No Directory selected");
        }else{
            try{
                File[] listOfFiles;
                indicoPictures = new IndicoPictures();
                selectedPath = selectedDirectory.getAbsolutePath();
                indicoPictures.loadFiles(selectedPath);
                listOfFiles=indicoPictures.getListOfFiles();
                for(File file : listOfFiles){
                    System.out.println(file.toString());
                    listView.getItems().add(file.getName());
                }

            } catch (NotAnImage e) {
                ErrorBox.display("NotAnImage exception","Folder must have only images.");
                e.printStackTrace();
            } catch (IndicoException e) {
                ErrorBox.display("Indico exception","Indico have some problems. Maybe wrong key.");
                e.printStackTrace();
            } catch (UnknownHostException e) {
                ErrorBox.display("UnknownHost exception","You may have problem with internet connection.");
                e.printStackTrace();
            } catch (IOException e) {
                ErrorBox.display("Input/Output exception","Folder must have only images. I don't fount any.");
                e.printStackTrace();
            } catch (NullPointerException e) {
                ErrorBox.display("Nullpointer exception","Folder must have only images. I don't fount any.");
                e.printStackTrace();
            } catch (Exception e) {
                ErrorBox.display("I have no idea what is the problem",":(");
                e.printStackTrace();
            }
        }
    }

    public void listenForListViewChanges(){
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
            File selectedFile = new File(selectedPath+"\\"+newValue);
            System.out.println("Selected item: " + selectedFile.toString());
            try {
                listOfProbabilities = indicoPictures.recognizeImage(selectedFile);
            } catch (SocketTimeoutException e) {
                ErrorBox.display("SocketTimedOut exception","You may have problem with internet connection.");
                e.printStackTrace();
            } catch (UnknownHostException e) {
                ErrorBox.display("UnknownHost exception","You may have problem with internet connection.");
                e.printStackTrace();
            } catch (IndicoException e){
                ErrorBox.display("Indico exception","Indico have some problems. Maybe wrong key.");
                e.printStackTrace();
            } catch (IOException e) {
                ErrorBox.display("Input/Output exception","Folder must have only images. I don't found any.");
                e.printStackTrace();
            }
            printBarChart(newValue);
            printPhoto(selectedFile);
        });
    }
    public void printBarChart(String newValue){
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        series1.setName(newValue);
        barChart.getXAxis().setLabel("guessed image content");
        barChart.getYAxis().setLabel("probabilities in [%]");
        barChart.setTitle("5 most probable guesses");
        barChart.setAnimated(false);
        for(Map.Entry<String,Double> entry : listOfProbabilities.entrySet()){
            String splitted[] =entry.getKey().split(",",2); //splitted[0] will be matched to first ",".
            series1.getData().add(new XYChart.Data<>(splitted[0], entry.getValue()));
        }
        if(!barChart.getData().isEmpty()) barChart.getData().removeAll(barChart.getData());
        barChart.getData().add(series1);
    }
    public void printPhoto(File selectedFile) {
        Image img = new Image(selectedFile.toURI().toString());
        imageView.setImage(img);

    }
}
