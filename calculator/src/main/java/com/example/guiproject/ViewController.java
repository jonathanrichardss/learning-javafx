package com.example.guiproject;

import com.example.guiproject.enums.OperationEnum;
import com.example.guiproject.util.Alerts;
import com.example.guiproject.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private TextField txFirstNumber;
    @FXML
    private TextField txSecondNumber;
    @FXML
    private Label lblResult;
    @FXML
    private Label lblCalcType;
    @FXML
    private Button sumBtn;
    @FXML
    private Button subBtn;
    @FXML
    private Button multiBtn;
    @FXML
    private Button divBtn;
    @FXML
    private Button clcBtn;
    @FXML
    private Button clearBtn;
    private boolean idSelectedOp;


    @FXML
    private void onBtnCalcAction() {
        try {
            setTxtFields();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            switch (lblCalcType.getText()) {
                case "+":
                    sum(txFirstNumber.getText(), txSecondNumber.getText());
                    break;
                case "-":
                    subtract(txFirstNumber.getText(), txSecondNumber.getText());
                    break;
                case "*":
                    multiply(txFirstNumber.getText(), txSecondNumber.getText());
                    break;
                case "/":
                    divide(txFirstNumber.getText(), txSecondNumber.getText());
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }
    private void sum(String num1, String num2) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);

        double result = number1 + number2;
        lblResult.setText(String.format("%.2f",result));
    }
    private void subtract(String num1, String num2) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);

        double result = number1 - number2;
        lblResult.setText(String.format("%.2f",result));
    }
    private void multiply(String num1, String num2) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);

        double result = number1 * number2;
        lblResult.setText(String.format("%.2f",result));
    }
    private void divide(String num1, String num2) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);

        double result = number1 / number2;
        lblResult.setText(String.format("%.2f",result));
    }

    private void setLblCalcType() {
        sumBtn.setOnAction(e -> lblCalcType.setText(OperationEnum.SUM.getOperation()));
        subBtn.setOnAction(e -> lblCalcType.setText(OperationEnum.SUB.getOperation()));
        multiBtn.setOnAction(e -> lblCalcType.setText(OperationEnum.MULT.getOperation()));
        divBtn.setOnAction(e -> lblCalcType.setText(OperationEnum.DIV.getOperation()));

        clearBtn.setOnAction(e -> {
            txFirstNumber.clear();
            txSecondNumber.clear();
        });
    }

    private void setTxtFields() {
        if (txFirstNumber.getText().isEmpty() || txSecondNumber.getText().isEmpty()) {
            Alerts.showAlert("Error", "Empty Fields", "Need to fill both fields!", Alert.AlertType.ERROR);
            System.out.println("Entrou no IF");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setLblCalcType();
        Constraints.setTextFieldDouble(txFirstNumber);
        Constraints.setTextFieldDouble(txSecondNumber);
        Constraints.setTextFieldMaxLength(txFirstNumber, 12);
        Constraints.setTextFieldMaxLength(txSecondNumber, 12);
    }
}
