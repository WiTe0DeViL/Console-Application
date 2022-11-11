package controller;

import model.User;
import view.UserOption;

import java.sql.*;
import java.util.Scanner;

public class Admin implements Processable {

    Connection connector = null;
    Validation validation;
    Scanner input = new Scanner(System.in);

    public Admin() {
        validation = new Validation();
    }

    @Override
    public User login(String email, String password) throws SQLException {
        connector = DataBaseConnection.connect();
        Statement statement = connector.createStatement();
        ResultSet resultSet = statement.executeQuery(loginFetch + "admin");
        return validation.validator(resultSet, email, password);
    }

    @Override
    public void search() {

    }

    public void process() throws SQLException {
        byte option = input.nextByte();
        switch (option) {
            case 1 -> viewUsers();
        }
    }

    private void viewUsers() throws SQLException {
        connector = DataBaseConnection.connect();
        Statement statement = connector.createStatement();
        ResultSet resultSet = statement.executeQuery(fetchAll + "user");
        new UserOption().displayUserDetails(resultSet);
    }
}