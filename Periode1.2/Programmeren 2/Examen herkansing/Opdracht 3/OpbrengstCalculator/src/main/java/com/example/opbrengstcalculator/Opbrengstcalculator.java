package com.example.opbrengstcalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Opbrengstcalculator extends Application {

    private Label locationLabel;
    private ComboBox<String> locationComboBox;
    private Label installedPowerLabel;
    private TextField installedPowerTextField;
    private Button calculateButton;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Opbrengstcalculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Scene scene = new Scene(grid, 375, 150);
        primaryStage.setScene(scene);

        locationLabel = new Label("Locatie in Nederland:");
        grid.add(locationLabel, 0, 0);

        locationComboBox = new ComboBox<>();
        locationComboBox.getItems().addAll("Oost", "Midden", "West");
        locationComboBox.setValue("Oost");
        grid.add(locationComboBox, 1, 0);

        installedPowerLabel = new Label("Geïnstalleerd vermogen (Wp):");
        grid.add(installedPowerLabel, 0, 1);

        installedPowerTextField = new TextField();
        grid.add(installedPowerTextField, 1, 1);

        resultLabel = new Label();
        resultLabel.setText("Uw jaaropbrengst wordt naar schatting xxxx kWh");
        grid.add(resultLabel, 0, 2, 2, 1);

        calculateButton = new Button("Bereken");
        grid.add(calculateButton, 1, 3);

        calculateButton.setOnAction(event -> calculateYearlyProduction());

        primaryStage.show();
    }

    private void calculateYearlyProduction() {
        double installedPower;
        try {
            installedPower = Double.parseDouble(installedPowerTextField.getText());
            if (installedPower <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Voer een geldig positief getal in.");
            return;
        }

        String location = locationComboBox.getValue();
        double efficiency;
        switch (location) {
            case "Oost":
                efficiency = 0.85;
                break;
            case "Midden":
                efficiency = 0.93;
                break;
            case "West":
                efficiency = 0.98;
                break;
            default:
                efficiency = 0.0;
                break;
        }

        double production = installedPower * efficiency * 365.0;
        resultLabel.setText(String.format("Uw jaaropbrengst wordt naar schatting %.2f kWh", production / 1000.0));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
