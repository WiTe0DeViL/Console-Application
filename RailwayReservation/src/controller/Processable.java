package controller;

import java.sql.SQLException;

public interface Processable extends Queries{
    boolean login(String username, String password) throws SQLException;

    void search();
}
