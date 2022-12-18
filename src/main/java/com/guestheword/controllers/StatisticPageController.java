package com.guestheword.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.guestheword.gui.GamePage;
import com.guestheword.users.UserList;

/** Statistic window */
public class StatisticPageController {

    @FXML private Label labelLogin0,labelLogin1, labelLogin2,labelLogin3, labelLogin4,
                         labelLogin5, labelLogin6, labelLogin7, labelLogin8, labelLogin9;

    @FXML private Label labelGameTime0, labelGameTime1,labelGameTime2,labelGameTime3,
                         labelGameTime4,labelGameTime5, labelGameTime6,labelGameTime7,
                         labelGameTime8,labelGameTime9;

    @FXML private Label labelTrainedWords0, labelTrainedWords1, labelTrainedWords2, labelTrainedWords3,
                         labelTrainedWords4, labelTrainedWords5, labelTrainedWords6, labelTrainedWords7,
                         labelTrainedWords8, labelTrainedWords9;

    @FXML private Label labelGuessedWords0, labelGuessedWords1, labelGuessedWords2, labelGuessedWords3,
                         labelGuessedWords4, labelGuessedWords5,labelGuessedWords6,labelGuessedWords7,
                         labelGuessedWords8,labelGuessedWords9;

    @FXML private Button backButton;

    /** Create statistic */
    public void pushButtonShowStatistic() {
        setLabels(0,labelLogin0,labelGameTime0,labelTrainedWords0,labelGuessedWords0);
        setLabels(1,labelLogin1,labelGameTime1,labelTrainedWords1,labelGuessedWords1);
        setLabels(2,labelLogin2,labelGameTime2,labelTrainedWords2,labelGuessedWords2);
        setLabels(3,labelLogin3,labelGameTime3,labelTrainedWords3,labelGuessedWords3);
        setLabels(4,labelLogin4,labelGameTime4,labelTrainedWords4,labelGuessedWords4);
        setLabels(5,labelLogin5,labelGameTime5,labelTrainedWords5,labelGuessedWords5);
        setLabels(6,labelLogin6,labelGameTime6,labelTrainedWords6,labelGuessedWords6);
        setLabels(7,labelLogin7,labelGameTime7,labelTrainedWords7,labelGuessedWords7);
        setLabels(8,labelLogin8,labelGameTime8,labelTrainedWords8,labelGuessedWords8);
        setLabels(9,labelLogin9,labelGameTime9,labelTrainedWords9,labelGuessedWords9);
    }

    /** Back to main window */
    public void pushBackButton() throws Exception {
        GamePage gamePage = new GamePage();
        gamePage.showWindowGamePage();
        Stage stageLogin = (Stage) backButton.getScene().getWindow();
        stageLogin.close();
    }

    /** Set labels info */
    private void setLabels(int userNum, Label labelLogin, Label labelGameTime, Label labelTrainedWords, Label labelGuessedWords) {
        /* Sort user list*/
        UserList.getUserArrayListSorted();
        /* Setup rows while users are existed in the list */
        if (userNum < UserList.getUserArrayList().size()) {
            labelLogin.setText(UserList.getUserArrayList().get(userNum).getLogin());
            labelGameTime.setText(UserList.getUserArrayList().get(userNum).setTrainedTimeToString());
            labelTrainedWords.setText(Integer.toString(UserList.getUserArrayList().get(userNum).getTrainedWords()));
            labelGuessedWords.setText(Integer.toString(UserList.getUserArrayList().get(userNum).getGuessedWords()));
        }
    }
}