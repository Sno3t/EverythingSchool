module com.example.opbrengstcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.opbrengstcalculator to javafx.fxml;
    exports com.example.opbrengstcalculator;
}