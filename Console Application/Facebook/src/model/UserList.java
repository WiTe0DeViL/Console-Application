package model;

import java.util.ArrayList;

public class UserList {
    static private final ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(User user) {
        userList.add(user);
    }
}
