package com.guestheword.controllers;

import javafx.fxml.FXML;
import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import com.guestheword.auxillary.*;
import com.guestheword.words.Wordlist;

/** GUI controller class for adding new words */
public class AddNewWordPageController {

    @FXML private TextField addNewWordEN, addNewWordRU;
    @FXML private Label labelWarning;

    /** Add the new pair of words to guess */
    public void setAddNewWord() {
        if (!addNewWordRU.getText().matches(Texts.RU_TEXT) || !addNewWordEN.getText().matches(Texts.EN_TEXT)) {
            setLabelWarningStatus(Colors.RED_COLOR,Texts.BAD_SYMBOLS);
        } else {
            Wordlist.addNewWord(addNewWordEN,Texts.LIST_EN);
            Wordlist.addNewWord(addNewWordRU,Texts.LIST_RU);
            setLabelWarningStatus(Colors.GREEN_COLOR,Texts.DONE);
            addNewWordEN.clear();
            addNewWordRU.clear();
        }
    }

    /** Setup GUI preferences when try to add new words */
    private void setLabelWarningStatus(String status, String labelText) {
        labelWarning.setText(labelText);
        labelWarning.setStyle(status);
        labelWarning.setVisible(true);
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> labelWarning.setVisible(false));
        pause.play();
    }

}