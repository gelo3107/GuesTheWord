package com.guestheword.auxillary;

/** Class contains all hard texts used in the program */
public class Texts {

    /* AddNewPageController class*/
    public static final String DONE = "Done!";
    public static final String BAD_SYMBOLS = "No words or bad symbols";

    /* RegisterController class */
    public static final String NULL_LOGIN = "Out or incorrect login";
    public static final String EXISTED_LOGIN = "Login already existed";
    public static final String SHORT_PSW = "Password should contains 5 symbols at least";
    public static final String DIFF_PSW = "Passwords does not match";
    public static final String USER_ADDED = "New user is added!";

    /* GamePageController class*/
    public static final String EMPTY_TEXT = "";
    public static final String RIGHT = "RIGHT!";
    public static final String WRONG = "WRONG!";

    /* LoginController class */
    public static final String INCORRECT_PSW = "Incorrect password";
    public static final String INCORRECT_LOGIN = "Incorrect login";
    public static final String OUT_OF_LOGIN = "Put login";
    public static final String PUSH_START = "Push Start";

    /* files */
    public static final String USER_LIST = "user.user";
    public static final String LIST_RU =  "RU.txt";
    public static final String LIST_EN =  "EN.txt";

    /* formatted templates*/
    public static final String RU_TEXT = "[а-яА,\s,-]+";
    public static final String EN_TEXT = "[a-zA-Z,\s,-]+";
    public static final String TIME_TEMPLATE = "%02dh:%02dm:%02ds";
}
