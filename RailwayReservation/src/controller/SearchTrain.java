package controller;

import model.Train;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SearchTrain implements Queries {
    static Connection connection = null;

    public Train search(String from, String to, Date date) throws SQLException {
        ResultSet resultSet = getTrainInstance();
        while (resultSet.next()) {
            String traincode = resultSet.getString("traincode");
            int seats = resultSet.getInt("seats");
            int compartment = resultSet.getInt("compartment");
            String departFrom = resultSet.getString("departfrom");
            String departTo = resultSet.getString("departto");
            if (departFrom.equals(from) && departTo.equals(to)) {
                return new Train(traincode, date, from, to, seats, compartment);
            }
        }
        return null;
    }

    public ResultSet getTrain() throws SQLException {
        return getTrainInstance();
    }

    private ResultSet getTrainInstance() throws SQLException {
        connection = DataBaseConnection.connect();
        Statement statement = connection.createStatement();
        return statement.executeQuery(fetchAll + "traindetails");
    }
}

