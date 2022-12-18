package com.guestheword.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/** GUI register new user */
public class Register extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Register.class.getResource("Register.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("New user registration");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void showWindowRegister() throws Exception{
        start(stage);
    }

}