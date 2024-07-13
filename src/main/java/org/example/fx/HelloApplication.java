package org.example.fx;

import Dao.UserDaoImpl;
import User.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        // For User
        UserPage userPage = new UserPage(stage);
        Scene userScene = userPage.userPageScene();

        stage.setScene(userScene);
        stage.setTitle("Registration Form");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}