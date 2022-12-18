package com.guestheword.words;

/** Create set of words for guessing */
public class Wordset {
    
    private String guesWord, guesWordPrimary;
    private String randomWord_1;
    private String randomWord_2;
    private String randomWord_3;
    
    private int guesWordIndex;
    private int randomWordIndex_1;
    private int randomWordIndex_2;
    private int randomWordIndex_3;

    private static final int BUTTON_NUMBERS =4;

    /** Wordset object constructor */
    public Wordset() {

        /* Setup word index to guess randomly from wordlist */
        guesWordIndex = getWordIndex();

        /* Setup other words indexes randomly */
        do{
            randomWordIndex_1 = getWordIndex();
        } while (randomWordIndex_1 == guesWordIndex);
        do{
            randomWordIndex_2 = getWordIndex();
        } while (randomWordIndex_2 == guesWordIndex || randomWordIndex_2 == randomWordIndex_1 );
        do{
            randomWordIndex_3 = getWordIndex();
        } while (randomWordIndex_3 == guesWordIndex || randomWordIndex_3 == randomWordIndex_1 || randomWordIndex_3 == randomWordIndex_2);

        /* Setup words from indexes */
        guesWord        = Wordlist.getPrimaryList().get(guesWordIndex);
        guesWordPrimary = Wordlist.getSecondaryList().get(guesWordIndex);
        randomWord_1    = Wordlist.getPrimaryList().get(randomWordIndex_1);
        randomWord_2    = Wordlist.getPrimaryList().get(randomWordIndex_2);
        randomWord_3    = Wordlist.getPrimaryList().get(randomWordIndex_3);
    }

    /* Getters */
    public String getGuesWord()         { return guesWord;}
    public int getGuesWordIndex()       { return guesWordIndex; }
    public String getGuesWordPrimary()  { return guesWordPrimary; }
    public String getRandomWord_1()     { return randomWord_1; }
    public String getRandomWord_2()     { return randomWord_2; }
    public String getRandomWord_3()     { return randomWord_3; }

    /* Get index of the word to guess randomly */
    private static int getWordIndex(){
        return (int) (Math.random()*Wordlist.getPrimaryList().size());
    }

    /* Get button number with right word */
    public static int selectRightButton (){
        return (int) ((Math.random()*BUTTON_NUMBERS) +1);
    }

}