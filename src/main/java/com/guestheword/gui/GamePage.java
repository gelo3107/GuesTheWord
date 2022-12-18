package com.guestheword.gui;

import com.guestheword.users.UserList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/** GUI main game page */
public class GamePage extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GamePage.class.getResource("GamePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Guess the word!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        /* Download users from file to UserList*/
        UserList.getUserListFromFile();
    }

    public static void main(String[] args) {
        launch();
    }

    public void showWindowGamePage() throws Exception{
        start(stage);
    }

}