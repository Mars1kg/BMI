package bmi;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private ComboBox<String> unitSelector; // dropdown menu
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private Label resultLabel;

    @FXML
    private void updateFields() {
        String selectedUnit = unitSelector.getValue();
        if ("Имперские".equals(selectedUnit)) {
            heightField.setPromptText("Введите рост в дюймах (inches)");
            weightField.setPromptText("Введите вес в фунтах (lbs)");
        } else {
            heightField.setPromptText("Введите рост в сантиметрах (cm)");
            weightField.setPromptText("Введите вес в килограммах (kg)");
        }
    }
    @FXML
    private void calculateBMI() {
        double bmi = 0;
        String status;

//            String selectedUnit = unitSelector.getValue();
//            double height;
//            double weight;

        if (unitSelector.getValue().equals("Адекватная метрика")) {
            double height = Double.parseDouble(heightField.getText()) / 100; // перевод в метры
            double weight = Double.parseDouble(weightField.getText());
            bmi = Calculator.bodyMassIndexFormula(weight, height, true);

        } else if (unitSelector.getValue().equals("Имперские")) { // Имперские
            double heightImperial = Double.parseDouble(heightField.getText()) * 0.0254; // перевод дюймы в метры
            double weightImperial = Double.parseDouble(weightField.getText()) * 0.453592; // перевод фунты в килограммы
            bmi = Calculator.bodyMassIndexFormula(weightImperial, heightImperial, false);
        }

//            double bmi = Calculator.bodyMassIndexFormula(weight, height, selectedUnit.equals("Адекватная метрика"));
        status = Calculator.statusBMI(bmi);
        resultLabel.setText(status);
    }

    @FXML
    private void clearFields() {
        heightField.clear();
        weightField.clear();
        resultLabel.setText("");
        unitSelector.getSelectionModel().clearSelection();
    }
}