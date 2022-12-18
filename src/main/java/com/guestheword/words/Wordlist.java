package com.guestheword.words;

import java.io.*;
import java.util.ArrayList;

import com.guestheword.auxillary.Texts;
import javafx.scene.control.TextField;
import com.guestheword.controllers.GamePageController;

/** Lists with words creation class */
public class Wordlist {

    /* English and Russian words lists */
    protected static ArrayList<String> listEN = new ArrayList<>();
    protected static ArrayList<String> listRU = new ArrayList<>();

    /** Get primary list: list of words to guess */
    public static ArrayList<String> getPrimaryList() {
        if (GamePageController.isGetPrimaryListEN()) return listEN;
        return listRU;
    }

    /** Get secondary list: list of words matched guess words */
    public static ArrayList<String> getSecondaryList() {
        if (GamePageController.isGetPrimaryListEN()) return listRU;
        return listEN;
    }

    /** Add new word in the list of words */
    public static void addNewWord(TextField getWord, String listName){
        File file = new File(listName);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))) {
            bufferedWriter.newLine();
            bufferedWriter.write(getWord.getText().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Update word lists public method */
    public static void updateList() {
        listRU.clear();     updateList(Texts.LIST_RU,listRU);
        listEN.clear();     updateList(Texts.LIST_EN,listEN);
    }

    /** Update word list private method */
    private static void updateList(String pathName, ArrayList<String> listName) {
        try (BufferedReader in = new BufferedReader(new FileReader(pathName))){
            String word;
            while ((word = in.readLine()) != null) listName.add(word);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}