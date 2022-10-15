package controller;

import view.UserOption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchTrain implements Queries {
    static Connection connection = null;

    public void search(String from, String to) {

    }

    public ResultSet getTrain() throws SQLException {
        connection = DataBaseConnection.connect();
        Statement statement = connection.createStatement();
        return statement.executeQuery(fetchAll + "traindetails");
    }
}

