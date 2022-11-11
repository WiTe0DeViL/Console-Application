package controller;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

class Validation {
    public User validator(ResultSet resultSet, String email, String password) throws SQLException {
        User user = null;
        while (resultSet.next()) {
            String getEmail = resultSet.getNString("email");
            String getPassword = resultSet.getNString("password");
            if (email.equals(getEmail) && password.equals(getPassword)) {
                if (!resultSet.getString("name").equals("admin")) {
                    int id = resultSet.getInt("userid");
                    int age = resultSet.getInt("age");
                    String name = resultSet.getString("name");
                    user = new User(id, name, age, email, password);
                    System.out.println("Successfully Logged In");
                } else {
                    String name = resultSet.getString("name");
                    user = new User(name, email);
                }
            }
        }
        return user;
    }
}
