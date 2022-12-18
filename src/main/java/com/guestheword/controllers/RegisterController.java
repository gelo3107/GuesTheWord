package com.guestheword.controllers;

import javafx.fxml.FXML;
import java.io.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.*;
import javafx.animation.PauseTransition;
import com.guestheword.auxillary.*;
import com.guestheword.gui.GamePage;
import com.guestheword.users.UserList;
import com.guestheword.users.User;

/** GUI controller class for new user register window */
public class RegisterController {

    @FXML private TextField loginTextField, passwordTextField, passwordCheckTextField;
    @FXML private Button registerButton, backButton;
    @FXML private Label statusLabel;

    /** Register new user */
    public void registerNewUser() throws FileNotFoundException {
        /* Initialize fields*/
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        String passwordRepeated = passwordCheckTextField.getText();

        if (loginExists(login)) {
            /* Login should not be already existed */
            setStatusLabel(statusLabel, Texts.EXISTED_LOGIN, Colors.RED_COLOR);
        } else {
            /* Login should not be empty, should not contain spaces and should be not longer than 10 symbols */
            if(login.isEmpty() || login.contains(" ") || login.length() > 10) {
                setStatusLabel(statusLabel,Texts.NULL_LOGIN, Colors.RED_COLOR);
            } else {
                /* Password length should be more than 5 symbols */
                if (password.length() <= 4){
                    setStatusLabel(statusLabel,Texts.SHORT_PSW, Colors.RED_COLOR);
                } else {
                    /* Password should match to password repeat */
                    if(!password.equals(passwordRepeated)){
                        setStatusLabel(statusLabel,Texts.DIFF_PSW, Colors.RED_COLOR);
                    /* Create new user */
                    } else {
                        User user = new User(login, password);
                        /* Add new user in UserList */
                        UserList.getUserArrayList().add(user);

                        /* Update serialized file on HD*/
                        UserList.getFileFromUserList();

                        /* Update GUI*/
                        setStatusLabel(statusLabel,Texts.USER_ADDED, Colors.GREEN_COLOR);
                        loginTextField.clear();
                        passwordTextField.clear();
                        passwordCheckTextField.clear();
                    }
                }
            }
        }
    }

    /** Update label and fields statuses */
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

    /** Check if login already existed */
    private static boolean loginExists(String currentLogin) {
        for (User user : UserList.getUserArrayList()) {
            if (currentLogin.equals(user.getLogin())) return true;
        }
        return false;
    }

    /** Back to main window */
    public void goBack() throws Exception{
        GamePage gamePage = new GamePage();
        gamePage.showWindowGamePage();
        Stage stageLogin = (Stage) backButton.getScene().getWindow();
        stageLogin.close();
    }
}