module com.example.examenjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires eu.hansolo.tilesfx;

    opens com.example.examenjavafx to javafx.fxml;
    exports com.example.examenjavafx;
}