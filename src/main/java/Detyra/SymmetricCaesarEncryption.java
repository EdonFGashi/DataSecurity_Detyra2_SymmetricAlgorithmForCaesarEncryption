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

    //Funksioni per enkriptim
    private String caesarEncrypt(String plainTxt, int shift){
        StringBuilder cipherTxt = new StringBuilder();
        for (char s : plainTxt.toCharArray()){
            if(Character.isLetter(s)){
                s = (char) (s + (shift % 26));
            }
            cipherTxt.append(s);
        }
        return cipherTxt.toString();
    }

    //Funksioni per dekriptim
    private String caesarDecrypt(String cipherTxt, int shift){
        StringBuilder plainTxt = new StringBuilder();
        for (char s : cipherTxt.toCharArray()){
            if(Character.isLetter(s)){
                s = (char) (s - ((shift + 26) % 26));
            }
            plainTxt.append(s);
        }
        return plainTxt.toString();
    }
}
