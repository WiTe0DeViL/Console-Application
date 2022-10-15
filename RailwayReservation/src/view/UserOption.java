package view;

import controller.Admin;
import controller.ManageUser;
import controller.SearchTrain;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserOption {


    enum choices {
        Login, Register, Search;
    }

    Scanner input = new Scanner(System.in);

    ManageUser manageUser = null;
    Admin admin = null;
    SearchTrain searchTrain = null;

    static Connection connector = null;

    public UserOption() {
        manageUser = new ManageUser();
        admin = new Admin();
    }

    public void userOptions() {
        System.out.println("1. Login\n2. Register\n3. Search");
        System.out.println("Enter any option : ");
        try {
            switch (manageUser.isValidOption()) {
                case 1 -> loginProcess();
                case 2 -> register();
                case 3 -> search();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error Occurred! on SQL");
        } catch (ParseException e) {
            throw new RuntimeException("Error Occurred! on Date");
        }
    }

    private void search() throws SQLException, ParseException {
//        System.out.println("Do ou want to display all trains");
        ResultSet resultSet = searchTrain.getTrain();
        displayTrainDetails(resultSet);
//        System.out.print("Depart From : ");
//        String from = input.next();
//        System.out.print("Depart To : ");
//        String to = input.next();
//        System.out.print("Enter the date in the format of (DD/MM/YYYY) : ");
//        String data = input.next();
//        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
//        new SearchTrain().search(from,to);
    }


    public void displayTrainDetails(ResultSet resultSet) throws SQLException {
        System.out.println("---------------------------------------------------");
        System.out.printf("|%-10s|%-3s|%-2s|%-15s|%-15s|%n", "TrainCode", "Seats", "Compartment", "From", "TO");
        System.out.println("---------------------------------------------------");
        while (resultSet.next()) {
            String traincode = resultSet.getString("traincode");
            int seats = resultSet.getInt("seats");
            int comp = resultSet.getInt("compartment");
            String from = resultSet.getString("departfrom");
            String to = resultSet.getString("departto");
            System.out.printf("|%-10s|%-3s|%-2s|%-15s|%-15s|%n", traincode, seats, comp, from, to);
        }
        System.out.println("----------------------------------------------------");

    }


    private void loginProcess() throws SQLException {
        String[] credentials = loginCredentials();
        if (manageUser.login(credentials[0], credentials[1]))
            System.out.println("User Logged In!");
        else if (admin.login(credentials[0], credentials[1])) {
            System.out.println("Admin Logged In!");
            adminOptions();
        } else System.out.println("Invalid User!");
    }

    public void displayUserDetails(ResultSet resultSet) throws SQLException {
        System.out.println("---------------------------------------------------");
        System.out.printf("|%-5s|%-10s|%-6s|%-20s|%n", "S.No", "name", "age", "email");
        System.out.println("---------------------------------------------------");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String email = resultSet.getNString("email");
            int id = resultSet.getInt("userid");
            System.out.printf("|%-5s|%-10s|%-6s|%-20s|%n", id, name, age, email);
        }
        System.out.println("----------------------------------------------------");

    }


    private void adminOptions() throws SQLException {
        System.out.println("1. View users");
        System.out.println("2. View Trains");
        System.out.println("3. Change Routs");
        System.out.println("4. Add train");
        System.out.print("Enter your option : ");
        admin.process();
    }

    private void register() throws SQLException {
        System.out.print("Enter your name : ");
        String name = input.next();
        System.out.print("Enter your age : ");
        Byte age = input.nextByte();
        System.out.print("Enter your email : ");
        String email = input.next();
        System.out.print("Enter your password : ");
        String password = input.next();
        System.out.print("Confirm Password : ");
        String confirmPassword = input.next();
        if (password.equals(confirmPassword))
            manageUser.userRegisteration(new User(name, age, email, password));
        else {
            System.out.println("Confirm Password Mismatch ");
            System.out.print("Enter correct Confirm Password : ");

        }

    }

    String[] loginCredentials() {
        System.out.print("Enter email : ");
        String email = input.next();
        System.out.print("Enter password : ");
        String password = input.next();
        return new String[]{email, password};
    }


}
