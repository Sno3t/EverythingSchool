package com.example.demo3;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");

        Button clear = new Button("Clear");
        Button add = new Button("Add");
        Button subtract = new Button("Subtract");
        Button multiply = new Button("Multiply");
        Button divide = new Button("Divide");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();

        add.setOnAction(actionEvent -> {
            double Result = Double.parseDouble(tf1.getText()) + Double.parseDouble(tf2.getText());
            tf3.setText(String.valueOf(Result));
        });

        subtract.setOnAction(actionEvent -> {
            double Result = Double.parseDouble(tf1.getText()) - Double.parseDouble(tf2.getText());
            tf3.setText(String.valueOf(Result));
        });

        multiply.setOnAction(actionEvent -> {
            double Result = Double.parseDouble(tf1.getText()) * Double.parseDouble(tf2.getText());
            tf3.setText(String.valueOf(Result));
        });

        divide.setOnAction(actionEvent -> {
            double Result = Double.parseDouble(tf1.getText()) /  Double.parseDouble(tf2.getText());
            tf3.setText(String.valueOf(Result));
        });

        clear.setOnAction(actionEvent -> {
           tf1.setText("");
           tf2.setText("");
           tf3.setText("");
        });

        Label value1 = new Label("Value 1");
        Label value2 = new Label("Value 2");
        Label output = new Label("Output");


        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();

        hBox1.setPadding(new Insets(5));
        hBox2.setPadding(new Insets(5));
        hBox3.setPadding(new Insets(5));
        hBox.setPadding(new Insets(5));
        hBox3.setSpacing(3);

        hBox.getChildren().setAll(value1, tf1);
        hBox1.getChildren().setAll(value2, tf2);
        hBox2.getChildren().setAll(output, tf3);
        hBox3.getChildren().setAll(clear, add, subtract, multiply, divide);


        VBox vBox = new VBox();
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(hBox3);

        vBox.setPadding(new Insets(10));
        vBox.setSpacing(5);

        Scene scene = new Scene(vBox, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();

    }
}
