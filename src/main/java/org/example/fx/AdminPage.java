package org.example.fx;

import Dao.UserDaoImpl;
import User.User;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class AdminPage  {
    private Consumer<Void> onAdminPageClose;

    public AdminPage(Stage primaryStage) {
    }

    public Scene createAdminScene() {
        Label heading = new Label("Admin Page");
        heading.setFont(new Font("Arial", 20));

        Label id=new Label("ID: ");
        Label pwd = new Label("Password: ");

        TextField tf1=new TextField();
        PasswordField tf2=new PasswordField();

        Button login = new Button("Login");

        Button backButton = new Button("User");
        backButton.setOnAction(e -> {
            if (onAdminPageClose != null) {
                onAdminPageClose.accept(null); // Notify main app to switch back to main page
            }
        });

        HBox h1 = new HBox(id,tf1);
        HBox h2 = new HBox(pwd,tf2);


        GridPane root = new GridPane();
        root.addRow(1, h1);
        root.addRow(2 ,h2);
        root.addRow(3, login);

        root.addRow(4, backButton);

        login.setOnAction(e -> {
            UserDaoImpl dI = new UserDaoImpl();
            if (tf1.getText().equals("admin") && tf2.getText().equals("admin")) {
                HBox hBox = new HBox();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Login Successful, now you can view the data");
                alert.showAndWait();
                tf1.setText("");
                tf2.setText("");

                StringBuilder sb = new StringBuilder("Data\n");
                for (User u : dI.showAllUser()) {
                    sb.append(u).append("\n");
                }
                Label l = new Label(sb.toString());
                l.setWrapText(true);
                l.setMaxWidth(400);
                hBox.getChildren().add(l);
                root.addRow(6, hBox );
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid Credentials");
                alert.showAndWait();
            }

        });

        return new Scene(root, 500, 400);
    }

    public void setOnAdminPageClose(Consumer<Void> onAdminPageClose) {
        this.onAdminPageClose = onAdminPageClose;
    }
}
