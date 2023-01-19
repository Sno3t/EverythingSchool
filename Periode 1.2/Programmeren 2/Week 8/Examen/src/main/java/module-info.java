module com.example.examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;

    opens com.example.examen to javafx.fxml;
    exports com.example.examen;
}