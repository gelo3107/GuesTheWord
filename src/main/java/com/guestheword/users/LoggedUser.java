package com.guestheword.users;

/** Class setups logged user */
public class LoggedUser {

    private static User loggedUser;

    /* Setter, getter */
    public static User getLoggedUser()          { return loggedUser; }
    public static void setLoggedUser(User user) { loggedUser = user; }

}