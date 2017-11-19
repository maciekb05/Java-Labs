package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Hello");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("IndicoPicturesGUI");
        primaryStage.setScene(new Scene(root, 900, 550));
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1000);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
