package com.example.guiproject.util;

import javafx.scene.control.TextField;

public class Constraints {

    public static void setTextFieldDouble(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
                txt.setText(oldValue);
            }
        });
    }

    public static void setTextFieldMaxLength(TextField txt, int max) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.length() > max) {
                txt.setText(oldValue);
            }
        });
    }

    public static void setTextFieldInteger(TextField txt) {
        txt.textProperty().addListener((obs, old, newV) -> {
            if (newV != null && newV.matches("\\d")) {

            }
        });
    }

}
