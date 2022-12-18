package com.guestheword.controllers;

import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import com.guestheword.auxillary.*;
import com.guestheword.gui.GamePage;
import com.guestheword.users.*;

/** GUI login controller class */
public class LoginController {

    @FXML private TextField loginTextField;
    @FXML private PasswordField passwordTextField;
    @FXML private Button setLoginButton;
    @FXML private Label labelStatus;

    private Parent root;

    /** Login to start the game */
    public void setLogin(ActionEvent event) throws IOException {
        /* Check if login field is empty */
        if (loginTextField.getText().isEmpty()) {
            setStatusLabel(labelStatus, Texts.OUT_OF_LOGIN,Colors.RED_COLOR);
        } else {
            boolean loginIsCorrect = false;
            /* Review users collection to find user */
            for ( User user : UserList.getUserArrayList()) {
                /* If user is found */
                if (loginTextField.getText().equals(user.getLogin())){
                    loginIsCorrect = true;
                    /* If password is correct */
                    if (passwordTextField.getText().equals(user.getPassword())) {
                        /* Set a logged user */
                        LoggedUser.setLoggedUser(user);

                        /* Back to main game page*/
                        URL resources = GamePage.class.getResource("GamePage.fxml");
                        FXMLLoader loader = new FXMLLoader(resources);
                        root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Guess the word!");
                        stage.setResizable(false);

                        /* Create new main page controller and apply settings*/
                        GamePageController gamePageController = loader.getController();
                        gamePageController.labelWord.setText(Texts.PUSH_START);
                        gamePageController.labelLogin.setText(LoggedUser.getLoggedUser().getLogin());
                        gamePageController.labelTime.setText(LoggedUser.getLoggedUser().setTrainedTimeToString());
                        gamePageController.labelGuessedWords.setText(LoggedUser.getLoggedUser().setGuessedWordsInPersentages());
                        gamePageController.getButtonStart().setDisable(false);
                        gamePageController.radioButtonRU_EN.setDisable(false);
                        gamePageController.radioButtonEN_RU.setDisable(false);
                        stage.show();

                        /* Close Login window */
                        Stage stageLogin = (Stage) setLoginButton.getScene().getWindow();
                        stageLogin.close();

                        break;
                    /* If password is incorrect */
                    } else {
                        setStatusLabel(labelStatus,Texts.INCORRECT_PSW,Colors.RED_COLOR);
                    }
                }
            }
            /* If login is incorrect */
            if (!loginIsCorrect) {
                setStatusLabel(labelStatus,Texts.INCORRECT_LOGIN,Colors.RED_COLOR);
            }
        }
    }

    /** Return to main game page without login */
    public void goBack() throws Exception{
        GamePage gamePage = new GamePage();
        gamePage.showWindowGamePage();
        Stage stageLogin = (Stage) setLoginButton.getScene().getWindow();
        stageLogin.close();
    }

    /** Update label statuses */
     private static void setStatusLabel(Label label, String status, String color) {
        /* Set label texts and colors */
        label.setText(status);
        label.setStyle(color);
        label.setVisible(true);

        /* Set timeout of visibility */
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> label.setVisible(false));
        pause.play();
    }
}
