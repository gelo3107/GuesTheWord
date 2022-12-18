package com.guestheword.users;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import com.guestheword.auxillary.Texts;

/** UserList creation class*/
public class UserList implements Serializable {

    private static ArrayList<User> userArrayList = new ArrayList<User>();

    /* Getter */
    public static ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    /** UserList serialization */
    public static void getFileFromUserList() throws FileNotFoundException {
        try (ObjectOutputStream userListObject = new ObjectOutputStream(
                new FileOutputStream(Texts.USER_LIST,false))) {
                    userListObject.writeObject(userArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** UserList deserialization */
    public static void getUserListFromFile() throws FileNotFoundException {
        try (ObjectInputStream userListObject = new ObjectInputStream(
                new FileInputStream(Texts.USER_LIST))) {
                    userArrayList = (ArrayList<User>) userListObject.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** Sort UserList for statistic purposes*/
    public static void getUserArrayListSorted() {
        Collections.sort(userArrayList);
    }

}