package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

class Validation {
    public boolean validator(ResultSet resultSet, String email, String password) throws SQLException {
        boolean flag = false;
        while (resultSet.next()) {
            String getEmail = resultSet.getNString("email");
            String getPassword = resultSet.getNString("password");
            if (email.equals(getEmail) && password.equals(getPassword)) {
                flag = true;
                System.out.println("Successfully Logged In");
            }
        }
        return flag;
    }
}
