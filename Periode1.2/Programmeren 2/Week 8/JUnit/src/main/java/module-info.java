module com.junit.junit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.junit.junit to javafx.fxml;
    exports com.junit.junit;
}