module org.example.a6bmi {
    requires javafx.controls;
    requires javafx.fxml;

    opens bmi to javafx.fxml;
    exports bmi;
}