package com.guestheword.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/** GUI add new word */
public class AddNewWordPage extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddNewWordPage.fxml"));
        Scene scene = new Scene(root, 430, 200);
        stage.setTitle("Add new word");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void showWindowAddNewWord() throws Exception{
        start(stage);
    }
}
