module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.params;
    requires org.junit.platform.commons;
    requires org.junit.jupiter;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}