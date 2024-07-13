package org.example.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Label heading = new Label("Registration Form");
        heading.setFont(new Font("Arial", 20)); // Set

        Label name=new Label("Name: ");
        Label email = new Label("Email: ");
        Label department = new Label("Department: ");
        Label phone = new Label("Phone: ");

        TextField tf1=new TextField();
        TextField tf2=new TextField();
        TextField tf3 = new TextField();

        ComboBox<String> departmentComboBox = new ComboBox<>();
        departmentComboBox.getItems().addAll("CSE", "ECE", "MEC", "BCA");
        departmentComboBox.setValue("CSE");

        ComboBox<String> numberComboBox = new ComboBox<>();
        numberComboBox.getItems().addAll("+91", "+007", "+019");
        numberComboBox.setValue("+91");

        Button b = new Button("Submit");



        GridPane root = new GridPane();

        HBox h1 = new HBox(name, tf1);
        HBox h2 = new HBox(email, tf2);
        HBox h3 = new HBox(department, departmentComboBox);
        HBox h4 = new HBox(phone, numberComboBox, tf3);

        root.addRow(0, heading);
        root.addRow(1, h1);
        root.addRow(2, h2);
        root.addRow(3, h3);
        root.addRow(4, h4);
        root.addRow(5, b);
        root.setVgap(5);

        b.setOnAction(e -> {
            String nameValue = tf1.getText();
            String emailValue = tf2.getText();
            String departmentValue = departmentComboBox.getValue();
            String phoneNumber = tf3.getText();

            if (nameValue.isEmpty() || emailValue.isEmpty() || departmentValue.isEmpty() || phoneNumber.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Please enter all the details!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Form Successfully submitted");
                alert.showAndWait();


            }

            System.out.println("Name: " + nameValue);
            System.out.println("Email: " + emailValue);
            System.out.println("Department: " + departmentValue);
            System.out.println("Phone number: " + numberComboBox.getValue() + " " + phoneNumber);

        });

        Scene scene=new Scene(root,500,400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}