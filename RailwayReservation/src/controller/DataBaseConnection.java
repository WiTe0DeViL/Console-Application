package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public static Connection connection = null;

    private DataBaseConnection() {}

    static Connection connect() {
        try {
            if (connection == null) {
                String dbUrl = "jdbc:mysql://localhost:3306/railway";
                String user = "railway";
                String password = "railwayReservation";
                connection = DriverManager.getConnection(dbUrl, user, password);
            }
        } catch (Exception e) {
            System.err.println("Error Occurred");
        }
        return connection;
    }
}