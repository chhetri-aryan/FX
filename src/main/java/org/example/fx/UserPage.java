package org.example.fx;

import Dao.UserDaoImpl;
import User.User;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserPage {
    private final Stage primaryStage;
    UserPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void switchToAdminPage() {
        AdminPage adminPage = new AdminPage(primaryStage);
        Scene adminScene = adminPage.createAdminScene();

        primaryStage.setScene(adminScene);

        adminPage.setOnAdminPageClose((e) -> {
            primaryStage.setScene(userPageScene()); // Return to main page scene
        });
    }



    public Scene userPageScene() {
        Label heading = new Label("Registration Form");
        heading.setFont(new Font("Arial", 20));

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
        Button admin = new Button("Admin");

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
        root.addRow(6, admin);
        root.setVgap(5);

        b.setOnAction(e -> {
            String nameValue = tf1.getText();
            String emailValue = tf2.getText();
            String departmentValue = departmentComboBox.getValue();
            String phoneValue = tf3.getText();

            if (nameValue.isEmpty() || emailValue.isEmpty() || departmentValue.isEmpty() || phoneValue.isEmpty()) {
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

                UserDaoImpl dI = new UserDaoImpl();
                dI.addUser(new User(nameValue, emailValue, departmentValue, (numberComboBox.getValue() + " " + phoneValue)));

            }

            System.out.println("Name: " + nameValue);
            System.out.println("Email: " + emailValue);
            System.out.println("Department: " + departmentValue);
            System.out.println("Phone number: " + numberComboBox.getValue() + " " + phoneValue);

        });

        admin.setOnAction(e -> switchToAdminPage());



        return new Scene(root,500,400);

    }

}
