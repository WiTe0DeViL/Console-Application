package controller;

import model.*;

public class Admin {
    Admin() {
        hardCode();
    }

    UserList userList = new UserList();
    private final String[][] hardCodeData = {
            {"Bhams", "22", "Bhams@01", "bhams@gmail.com", "Bhams@1710"},
            {"Vipi", "22", "Vipi", "vipi@gmail.com", "Vipi@1710"},
            {"Vicky", "22", "Vicky@01", "vicky@gmail.com", "Vicky@1710"}
    };


    public void hardCode() {
        for (String[] userDetails : hardCodeData) {
            userList.setUserList(new User(userDetails[0], Byte.parseByte(userDetails[1]),
                    userDetails[2], userDetails[3], userDetails[4]));
        }



    }
}
