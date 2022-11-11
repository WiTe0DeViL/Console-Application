package controller;

import model.User;

import java.sql.SQLException;

public interface Processable extends Queries {
    User login(String username, String password) throws SQLException;

    void search();
}
