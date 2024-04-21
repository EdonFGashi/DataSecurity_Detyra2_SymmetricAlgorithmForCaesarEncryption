package Detyra;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SymmetricCaesarEncryption extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private int shift1;
    private int shift2;
    String shkronjat = "abcdefghijklmnopqrstuvwyz";
    char[] shkronjatArray = shkronjat.toCharArray();

    @Override
    public void start(Stage stage) {
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

        Label label22 = new Label("Shift value:");
        TextArea shiftDecrypt = new TextArea();
        shiftDecrypt.setPrefRowCount(2);
        shiftDecrypt.setWrapText(true);
        shiftDecrypt.setCursor(Cursor.TEXT);

        Button butoniDekripto = new Button("Decrypt");
        Button butoniClear2 = new Button("Clear");
        HBox row23 = new HBox(butoniDekripto, butoniClear2);
        row23.setSpacing(170);

        Label label23 = new Label("Plain text:");
        TextArea plainOutput = new TextArea();
        plainOutput.setPrefRowCount(5);
        plainOutput.setWrapText(true);
        plainOutput.setCursor(Cursor.TEXT);
        plainOutput.setEditable(false);

        //caktimi i nje borderi te pane-s
        BorderStroke borderStroke = new BorderStroke(
                javafx.scene.paint.Color.BLACK, // Border color
                BorderStrokeStyle.SOLID, // Border style
                CornerRadii.EMPTY, // border radius
                BorderWidths.DEFAULT // gjersia e kornizes
        );
        Border border = new Border(borderStroke);
        Insets padding = new Insets(10); // 10 pixels padding on all sides


        VBox paneEncrypt = new VBox(label,label11, plainInput, label12, shiftEncrypt, row3, label13, cipherOutput);
        paneEncrypt.setBorder(border);
        paneEncrypt.setPadding(padding);
        paneEncrypt.setMaxWidth(300);
        paneEncrypt.setMaxHeight(200);
        paneEncrypt.setSpacing(10);

        VBox paneDecrypt = new VBox(label2, label21, cipherInput, label22, shiftDecrypt, row23, label23, plainOutput);
        paneDecrypt.setBorder(border);
        paneDecrypt.setPadding(padding);
        paneDecrypt.setMaxWidth(300);
        paneDecrypt.setMaxHeight(200);
        paneDecrypt.setSpacing(10);
//-------------------------------------------------------------------------------------------------------

        FlowPane flowPane = new FlowPane(paneEncrypt, paneDecrypt);
        flowPane.setHgap(20);
        flowPane.setMaxWidth(630);
        flowPane.setMaxHeight(430);
        StackPane pane = new StackPane(flowPane);
        Scene scene = new Scene(pane, 800, 500);
        stage.setTitle("Symmetric Caesar Encryption");
        stage.setScene(scene);
        stage.show();

        Alert alert = new Alert(Alert.AlertType.ERROR);

        // inicializimi i error dialog box
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Invalid data");
        alert.setContentText("Type valid data.");

        //Inicializimi i eventit ne butonin per enkriptim
        butoniEnkripto.setOnAction(a -> {
            String inputEncryption = plainInput.getText();
            if (isNumber(shiftEncrypt.getText())) {
                shift1 = Integer.parseInt(shiftEncrypt.getText());
                String encryptedText = caesarEncrypt(inputEncryption, shift1);
                cipherOutput.setText(encryptedText);
            } else {
                alert.showAndWait();
            }
        });


        //Inicializimi i eventit ne butonin per fshierje
        butoniClear.setOnAction(b -> {
            plainInput.setText("");
            cipherOutput.setText("");
        });

        //Inicializimi i eventit ne butonin per dekrptim
        butoniDekripto.setOnAction(c -> {
            String inputDecryption = cipherInput.getText();
            if (isNumber(shiftDecrypt.getText())) {
                shift2 = Integer.parseInt(shiftDecrypt.getText());
                String decryptedText = caesarDecrypt(inputDecryption, shift2);
                plainOutput.setText(decryptedText);
            } else {
                alert.showAndWait();
            }
        });

        //Inicializimi i eventit ne butonin per fshierje
        butoniClear2.setOnAction(d -> {
            cipherInput.setText("");
            plainOutput.setText("");
        });
    }
    //------------------------------------------------------------------------------------------------

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
