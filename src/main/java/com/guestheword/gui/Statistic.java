package com.guestheword.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** GUI statistic */
public class Statistic extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Register.class.getResource("Statistic.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Statistic");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void showWindowStatistic() throws Exception{
        start(stage);
    }
}
