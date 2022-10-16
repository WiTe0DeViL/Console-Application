package controller;


import com.mysql.cj.util.StringInspector;
import model.User;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageUser implements Processable {
    Connection connector = null;
    Validation validation = null;

    public ManageUser() {
        validation = new Validation();
    }

    @Override
    public boolean login(String email, String password) throws SQLException {
        connector = DataBaseConnection.connect();
        Statement statement = connector.createStatement();
        ResultSet resultSet = statement.executeQuery(loginFetch + "user");
        return validation.validator(resultSet, email, password);
    }

    @Override
    public void search() {

    }

    public byte isValidOption() {
        byte option;
        while (true) {
            try {
                option = new Scanner(System.in).nextByte();
                if (option == 1 || option == 3) break;
                if (option <= 0 || option > 3) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Enter Correct Option : ");
            }
        }
        return option;
    }

    public void userRegisteration(User user) throws SQLException {
        connector = DataBaseConnection.connect();
        PreparedStatement preparedStatement = connector.prepareStatement(register);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setByte(2, user.getAge());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());

        int row = preparedStatement.executeUpdate();

        if (row > 0)
            System.out.println("User registered!");
        else System.err.println("Error Occurred");

    }
}
