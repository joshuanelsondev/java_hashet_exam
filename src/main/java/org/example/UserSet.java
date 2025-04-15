package org.example;

import java.util.ArrayList;
import java.util.HashSet;

public class UserSet {
    HashSet<String> users = new HashSet<String>();

    public boolean addUser(String userName) {
        if (userName == null || userName.trim().isEmpty()) throw new IllegalArgumentException();
        return users.add(userName);
    }

    public boolean removeUser(String userName) {
        return users.remove(userName);
    }

    public boolean containsUser(String userName) {
        return users.contains(userName);
    }

    public int getUserCount() {
        return users.size();
    }

    public ArrayList<String> getUsersWithPrefix(String prefix) {
        if (prefix == null) throw new IllegalArgumentException();
        ArrayList<String> usersWithPrefix = new ArrayList<>();
        for (String user : users) {
           if (user.contains(prefix)) {
               usersWithPrefix.add(user);
           }
        }

        return usersWithPrefix;
    }

    public boolean areAllUsersUnique(String[] arr) {
       if (arr == null)  throw new IllegalArgumentException();
       UserSet currentUserSet = new UserSet();

       for (String str : arr) {
           if (currentUserSet.containsUser(str)) {
               return false;
           }

           currentUserSet.addUser(str);
       }

       return true;
    }

}

