package com.guestheword.users;

import com.guestheword.auxillary.Texts;

import java.io.Serializable;
import java.util.Formatter;

/** User creation class*/
public class User  implements Comparable<User>, Serializable {

    private String login;
    private String password;
    private int trainedWords;
    private int guessedWords;
    private int trainedTime;

    /* Constructor used for registration new user */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.trainedWords = 0;
        this.guessedWords = 0;
        this.trainedTime = 0;
    }

    /* Getters */
    public String getLogin()        { return login;        }
    public String getPassword()     { return password;     }
    public int getTrainedWords()    { return trainedWords; }
    public int getGuessedWords()    { return guessedWords; }
    public int getTrainedTime()     { return trainedTime;  }

    /* Setters */
    public void setLogin(String login)              { this.login = login;               }
    public void setTrainedWords(int trainedWords)   { this.trainedWords = trainedWords; }
    public void setGuessedWords(int guessedWords)   { this.guessedWords = guessedWords; }
    public void setTrainedTime(int trainedTime)     { this.trainedTime = trainedTime;   }

    /** Trained time calculation in hh:mm:ss format */
    public String setTrainedTimeToString() {

        int sec = (trainedTime / 1000) % 60;
        int min = ((trainedTime / 1000) /60)%24;
        int hours = ((trainedTime / 1000) /60)/24;

        Formatter timeFormat = new Formatter();
        return timeFormat.format(Texts.TIME_TEMPLATE,hours,min,sec).toString();
    }

    /** Guessed words in % calculation */
    public String setGuessedWordsInPersentages(){
        return Integer.toString((int)(((double) guessedWords) /
                                      ((double) trainedWords) * 100)).concat("%");
    }

    /** compareTo() method overriding */
    @Override
    public int compareTo(User o) {
        return o.trainedTime - this.trainedTime;
    }

}