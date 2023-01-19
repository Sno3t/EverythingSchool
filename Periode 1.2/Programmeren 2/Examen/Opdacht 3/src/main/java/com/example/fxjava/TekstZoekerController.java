package com.example.fxjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class TekstZoekerController {

    @FXML
    private RadioButton capitals;

    @FXML
    private TextField find;

    @FXML
    private TextArea input;

    @FXML
    private TextArea output;

    @FXML
    private Button reset;


    @FXML
    public void resetButtonAction() {
        input.setText("");
        output.setText("");
    }

    public void search(){
        String text =  input.getText();
        if (!reset.isDefaultButton()){
            boolean contains = text.contains(find.getText());
            if (contains){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Arrays.toString(text.split(find.getText())));
                output.appendText(stringBuilder.toString());
            }

        } else {
            text.toLowerCase().contains(find.getText().toLowerCase());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Arrays.toString(text.split(find.getText())));
            output.appendText(stringBuilder.toString());
        }

    }
}
