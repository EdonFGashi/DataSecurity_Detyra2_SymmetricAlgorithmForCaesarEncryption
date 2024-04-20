module com.example.datasecurity_detyra2_symmetricalgorithmforcaesarencryption {
    requires javafx.controls;
    requires javafx.fxml;
    opens Detyra to javafx.graphics;

    opens com.example.datasecurity_detyra2_symmetricalgorithmforcaesarencryption to javafx.fxml;
    exports com.example.datasecurity_detyra2_symmetricalgorithmforcaesarencryption;
}