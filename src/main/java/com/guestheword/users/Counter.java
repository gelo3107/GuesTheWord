package com.guestheword.users;

/** Counter class to calculated game time, trained and guessed words*/
public class Counter {

    private int time;           /* Gaming time */
    private int allWords;
    private int guessedWords;
    private int start, finish;  /* Start and finish absolute time */

    /* Return game time */
    public int getTime() {
        setTime(start,finish);
        return time;
    }

    /* Calculate game time*/
    public void setTime(int start, int finish) {
        time = finish - start;
    }

    public int getAllWords() {
        return allWords;
    }

    public void setAllWords(int allWords) {
        this.allWords = allWords;
    }

    public int getGuessedWords() {
        return guessedWords;
    }

    public void setGuessedWords(int guessedWords) {
        this.guessedWords = guessedWords;
    }

    /* Start timer */
    public int startTime(){
       return start = (int) System.currentTimeMillis();
    }

    /* Stop timer */
    public int finishTime() {
        return finish = (int) System.currentTimeMillis();
    }

}