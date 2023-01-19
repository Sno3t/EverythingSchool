module com.example.fxjava {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.fxjava to javafx.fxml;
    exports com.example.fxjava;
}