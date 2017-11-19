package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorBox {
    public static void display(String title, String message) {
        message = message + " Check it! And try again.";
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setHeight(200);
        window.setWidth(500);
        Label label = new Label();
        label.setText(message);
        Button closeOKButton = new Button("OK! Got it!");
        closeOKButton.setOnAction(e -> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeOKButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
