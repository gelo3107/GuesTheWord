package com.guestheword.controllers;

import javafx.fxml.FXML;
import java.io.FileNotFoundException;
import javafx.stage.Stage;
import javafx.scene.control.*;
import com.guestheword.auxillary.*;
import com.guestheword.users.*;
import com.guestheword.gui.*;
import com.guestheword.words.*;

/** GUI controller class for main game page */
public class GamePageController{

    @FXML private Button  buttonStart, buttonFinish, buttonNextWord;
    @FXML private Button  buttonAnswer_1, buttonAnswer_2,buttonAnswer_3,buttonAnswer_4;
    @FXML protected Label labelWord, labelStatus, labelLogin, labelTime, labelGuessedWords;
    @FXML protected RadioButton radioButtonRU_EN, radioButtonEN_RU;
    @FXML protected static Label labelLoggedUser;

    private Button rightButton;
    private Wordset wordset;
    private static boolean getPrimaryListEN;
    private Counter counter;

    /** Invoked method when Start button is pushed */
    public void pushButtonStart(){
        /* new counter is created and timer is started */
        counter = new Counter();
        counter.startTime();

        /* disactivate stop game (means activate the game) */
        stopGame(false);

        /* update list of words. Required always then new game is starting
           in case if new words was added it the files */
        Wordlist.updateList();

        /* first word guessing starts automatically */
        pushButtonNextWord();
    }

    /** Invoked method when Finish button is pushed */
    public void pushButtonFinish () throws FileNotFoundException {
        /* activate stop game */
        stopGame(true);

        /* timer is stopped */
        counter.finishTime();

        /* setup default settings for buttons and labels */
        buttonAnswer_1.setText(Texts.EMPTY_TEXT);
        buttonAnswer_2.setText(Texts.EMPTY_TEXT);
        buttonAnswer_3.setText(Texts.EMPTY_TEXT);
        buttonAnswer_4.setText(Texts.EMPTY_TEXT);
        labelStatus.setText(Texts.EMPTY_TEXT);
        labelWord.setText(Texts.EMPTY_TEXT);
        setButtonsDisable(true);

        /* loggedUser fields update*/
        LoggedUser.getLoggedUser().setTrainedTime(LoggedUser.getLoggedUser().getTrainedTime() + counter.getTime());
        LoggedUser.getLoggedUser().setTrainedWords(LoggedUser.getLoggedUser().getTrainedWords() + counter.getAllWords());
        LoggedUser.getLoggedUser().setGuessedWords(LoggedUser.getLoggedUser().getGuessedWords() + counter.getGuessedWords());

        /* labels update */
        labelTime.setText(LoggedUser.getLoggedUser().setTrainedTimeToString());
        labelGuessedWords.setText(LoggedUser.getLoggedUser().setGuessedWordsInPersentages());

        /* file with serialized userArrayList update */
        UserList.getFileFromUserList();

        /* counter is reset*/
        counter = null;
    }

    /** Invoked method when Next button is pushed */
    public void pushButtonNextWord(){

        /* increase number of trained words */
        counter.setAllWords(counter.getAllWords()+1);

        /* setup initial buttons and label settings */
        labelStatus.setText(Texts.EMPTY_TEXT);
        setDefaultButton(buttonAnswer_1);
        setDefaultButton(buttonAnswer_2);
        setDefaultButton(buttonAnswer_3);
        setDefaultButton(buttonAnswer_4);

        /* enable answer buttons */
        setButtonsDisable(false);

        /* create set of words to guess */
        wordset = new Wordset();

        /* setup word to be guessed to the label */
        labelWord.setText(wordset.getGuesWordPrimary());
        labelWord.setStyle(Colors.WHITE_COLOR);

        /* select randomly button with correct answer */
        int rightWordButton = Wordset.selectRightButton();

        /* setup correct word to the one button and other random words to other buttons */
        switch (rightWordButton) {
            case 1 -> {
                buttonAnswer_1.setText(wordset.getGuesWord());
                rightButton = buttonAnswer_1;
                buttonAnswer_2.setText(wordset.getRandomWord_1());
                buttonAnswer_3.setText(wordset.getRandomWord_2());
                buttonAnswer_4.setText(wordset.getRandomWord_3());
            }
            case 2 -> {
                buttonAnswer_1.setText(wordset.getRandomWord_1());
                buttonAnswer_2.setText(wordset.getGuesWord());
                rightButton = buttonAnswer_2;
                buttonAnswer_3.setText(wordset.getRandomWord_2());
                buttonAnswer_4.setText(wordset.getRandomWord_3());
            }
            case 3 -> {
                buttonAnswer_1.setText(wordset.getRandomWord_1());
                buttonAnswer_2.setText(wordset.getRandomWord_2());
                buttonAnswer_3.setText(wordset.getGuesWord());
                rightButton = buttonAnswer_3;
                buttonAnswer_4.setText(wordset.getRandomWord_3());
            }
            case 4 -> {
                buttonAnswer_1.setText(wordset.getRandomWord_1());
                buttonAnswer_2.setText(wordset.getRandomWord_2());
                buttonAnswer_3.setText(wordset.getRandomWord_3());
                buttonAnswer_4.setText(wordset.getGuesWord());
                rightButton = buttonAnswer_4;
            }
        }

        /* disable NextWord button before any answerButton is pushed */
        buttonNextWord.setDisable(true);
    }

    /** Invoked method if Answer 1 button is pushed */
    public void pushButtonAnswer1(){
        pushButtonAnswer(buttonAnswer_1);
    }

    /** Invoked method if Answer 2 button is pushed */
    public void pushButtonAnswer2(){
        pushButtonAnswer(buttonAnswer_2);
    }

    /** Invoked method if Answer 3 button is pushed */
    public void pushButtonAnswer3(){
        pushButtonAnswer(buttonAnswer_3);
    }

    /** Invoked method if Answer 4 button is pushed */
    public void pushButtonAnswer4(){
        pushButtonAnswer(buttonAnswer_4);
    }

    /** Invoked method for radio button mode selection for primary word list setup */
    public void selectPrimaryLanguage(){
        if (radioButtonEN_RU.isSelected()) getPrimaryListEN = true;
        if (radioButtonRU_EN.isSelected()) getPrimaryListEN = false;
    }

    /** Invoked method if Menu Add new word selected */
    public void startAddNewWord() throws Exception{
        AddNewWordPage addNewWordPage = new AddNewWordPage();
        addNewWordPage.showWindowAddNewWord();
    }

    /** Invoked method if Menu Register selected */
    public void startRegister() throws Exception{
        Register register = new Register();
        register.showWindowRegister();
        closeMainPage();
    }

    /** Invoked method if Menu Login selected */
    public void startLogin() throws Exception{
        Login login = new Login();
        login.showWindowLogin();
        closeMainPage();
    }

    /** Invoked method if Menu Logout selected */
    public void logOut() throws Exception {
        GamePage gamePage = new GamePage();
        gamePage.showWindowGamePage();
        closeMainPage();
    }

    /** Invoked method if Menu Statistic selected */
    public void statistic() throws Exception {
        Statistic statistic = new Statistic();
        statistic.showWindowStatistic();
        closeMainPage();
    }

    /** Auxiliary method: if English word list is primary */
    public static boolean isGetPrimaryListEN(){
        return getPrimaryListEN;
    }

    /** Auxiliary method to activate / disactivate answerButton_1 ... 4 in different modes */
    private void setButtonsDisable(boolean disable){
        buttonAnswer_1.setDisable(disable);
        buttonAnswer_2.setDisable(disable);
        buttonAnswer_3.setDisable(disable);
        buttonAnswer_4.setDisable(disable);
    }

    /** Auxiliary method releasing logic when answerButton_1 ... 4 is pushed */
    private void pushButtonAnswer(Button button){
        /* check index of selected word */
        int buttonAswer1Index = Wordlist.getPrimaryList().indexOf(button.getText());

        /* check if index of selected word equals to index of right word */
        if (buttonAswer1Index == wordset.getGuesWordIndex()) {

            /* if yes -> invokes setStaus method with RIGHT setups */
            setStatus(button,Texts.RIGHT, Colors.GREEN_COLOR);

            /* increase number of guessed words*/
            counter.setGuessedWords(counter.getGuessedWords()+1);
        } else {
            /* if no -> invokes setStatus method with WRONG setups */
            setStatus(button,Texts.WRONG, Colors.RED_COLOR);
        }
        /* enable buttonNextWord in any case */
        buttonNextWord.setDisable(false);
    }

    /** Start button getter */
    public Button getButtonStart() {
        return buttonStart;
    }

    /** Close main page */
    public void closeMainPage(){
        Stage stageLogin = (Stage) buttonStart.getScene().getWindow();
        stageLogin.close();
    }

    /** Auxiliary method: setup colors and texts schemes when game starts or stops */
    private void stopGame (boolean active){
        /* active buttons when game starts */
        buttonFinish.setDisable(active);
        buttonNextWord.setDisable(active);

        /* active buttons when game stopped */
        buttonStart.setDisable(!active);
        radioButtonEN_RU.setDisable(!active);
        radioButtonRU_EN.setDisable(!active);
    }

    /** Auxiliary method: setup colors and texts schemes when answer is selected */
    private void setStatus(Button button, String setText, String setColor){
        labelStatus.setText(setText);
        labelStatus.setStyle(setColor);
        button.setStyle(setColor);
        rightButton.setStyle(Colors.GREEN_COLOR);
    }

    /** Auxiliary method: default setups to select next word */
    public void setDefaultButton (Button button){
        button.setStyle(Colors.WHITE_COLOR);
        button.setBackground(Colors.BLACK_COLOR);
    }
}