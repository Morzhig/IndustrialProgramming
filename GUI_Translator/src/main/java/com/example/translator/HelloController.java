package com.example.translator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    public TextField English;
    public TextField French;
    public Button button;

    public void onClick(ActionEvent actionEvent) throws Exception {
        initData();

        String eng = English.getText();

        French.replaceText(0, French.getText().length(), Dictionary.translate(eng));
    }

    public void initData() throws IOException {
        Dictionary.input_eng();
        Dictionary.input_fr();
    }
}