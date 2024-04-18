package Detyra;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SymmetricCaesarEncryption extends Application {
    public void start(Stage stage){
        TextArea plainInput = new TextArea();



        FlowPane flowPane = new FlowPane();
        StackPane pane = new StackPane(flowPane);
        Scene scene = new Scene(pane, 500, 800);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.show();
    }
}
