package com.example.demo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("The cake is a lie!");
        Label label = new Label("Is the cake a lie?");
        Scene mainView = new Scene(label, 720, 360);
        stage.setScene(mainView);
        stage.show();
    }
}
