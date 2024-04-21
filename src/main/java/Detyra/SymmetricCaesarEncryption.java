package Detyra;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SymmetricCaesarEncryption extends Application {
    private int shift1 ;
    private int shift2 ;
    String shkronjat = "abcdefghijklmnopqrstuvwyz";
    char[] shkronjatArray = shkronjat.toCharArray();
    public void start(Stage stage){
        //Komponentet e enkriptimit
        Label label = new Label("Encrypt");
        label.setFont(Font.font(20));
        Label label11 = new Label("Plain text");
        TextArea plainInput = new TextArea();

        plainInput.setPrefRowCount(5);
        plainInput.setWrapText(true);
        plainInput.setCursor(Cursor.TEXT);

        Label label12 = new Label("Shift value:");
        TextArea shiftEncrypt = new TextArea();

        shiftEncrypt.setPrefRowCount(2);
        shiftEncrypt.setWrapText(true);
        shiftEncrypt.setCursor(Cursor.TEXT);

        Button butoniEnkripto = new Button("Encrypt");
        Button butoniClear = new Button("Clear");
        HBox row3 = new HBox(butoniEnkripto, butoniClear);
        row3.setSpacing(170);

        Label label13 = new Label("Cipher text:");
        TextArea cipherOutput = new TextArea();
        cipherOutput.setPrefRowCount(5);

        cipherOutput.setWrapText(true);
        cipherOutput.setCursor(Cursor.TEXT);
        cipherOutput.setEditable(false);

         //Komponentet e dekriptimit
         Label label2 = new Label("Decrypt");
         label2.setFont(Font.font(20));
         Label label21 = new Label("Cipher text");
         TextArea cipherInput = new TextArea();
         cipherInput.setPrefRowCount(5);
         cipherInput.setWrapText(true);
         cipherInput.setCursor(Cursor.TEXT);

        VBox paneEncrypt = new VBox(label,label11, plainInput, label12, shiftEncrypt, row3, label13, cipherOutput);

        FlowPane flowPane = new FlowPane(paneEncrypt);
//        FlowPane flowPane = new FlowPane(paneEncrypt, paneDecrypt);
        StackPane pane = new StackPane(flowPane);
        Scene scene = new Scene(pane, 800, 500);
        stage.setTitle("Symmetric Caesar Encryption");
        stage.setScene(scene);
        stage.show();

        //Inicializimi i eventit ne butonin per enkriptim
        butoniEnkripto.setOnAction(a ->{
            String inputEncryption = plainInput.getText();
            if(isNumber(shiftEncrypt.getText())){
                shift1 = Integer.parseInt(shiftEncrypt.getText());
                String encryptedText = caesarEncrypt(inputEncryption, shift1);
                cipherOutput.setText(encryptedText);
            }
        });
    }

    //    Funksioni per enkriptim
    private String caesarEncrypt(String plainTxt, int shift){
        StringBuilder cipherTxt = new StringBuilder();
        for (char s : plainTxt.toCharArray()){
            if(Character.isLetter(s)){
                char start ;
                if(Character.isLowerCase(s)){
                    start = 'a';
                } else {
                    start = 'A';
                }
                s = (char) (start + (s - start +shift) % 26);

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
                char start ;
                if(Character.isLowerCase(s)){
                    start = 'a';
                } else {
                    start = 'A';
                }
                s = (char) (start + (s - start - shift + 26) % 26);
            }
            plainTxt.append(s);
        }
        return plainTxt.toString();
    }

    private boolean isNumber(String shiftInput){
        try{
            int shift = Integer.parseInt(shiftInput);
            return shift >= 1 && shift <= 26;
        } catch (NumberFormatException e){
            return false;
        }
    }


}
