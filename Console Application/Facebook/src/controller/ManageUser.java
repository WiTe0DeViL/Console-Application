package controller;

import model.User;
import model.UserList;
import view.LoginPage;

import java.util.Map;
import java.util.Scanner;

public class ManageUser {
    Admin admin = new Admin();
    Scanner scan = new Scanner(System.in);
    UserList userList = new UserList();
    LoginPage loginPage = new LoginPage();

    public User login(String userName, String password) {
        boolean flag = false;
        User user = new User();
        for (User userDetails : userList.getUserList()) {
            if (userDetails.getUserName().equals(userName) && userDetails.getPassword().equals(password)) {
                flag = true;
                user = userDetails;
            }
            if (!userDetails.getUserName().equals(userName) && userDetails.getPassword().equals(password))
                System.out.println("\nYou have entered wrong USERNAME!");
            if (userDetails.getUserName().equals(userName) && !userDetails.getPassword().equals(password)) {
                System.out.println("\nYou have entered wrong Password!");
            }
        }
        if (!flag) System.out.println("Wrong USERNAME and PASSWORD!");
        else System.out.println("Login successful");
        return user;
    }


    public void register(String name, byte age, String userName, String password, String confirmPassword) {
        userList.setUserList(new User(name, age, userName, password, confirmPassword));
    }

    public void getCredentials() {
        loginPage.options();
        WHILE:
        while (true) {
            try {
                byte option = new Scanner(System.in).nextByte();
                if (option > 2 || option < 0) throw new Exception();
                switch (option) {
                    case 1:
                        String[] credentials = getLoginDetails();
                        User user = login(credentials[0], credentials[1]);
                        if (!user.getName().equals(null))
//                            profile(user);
//                            personalFeed(user);
                            suggessions(user);
//                              friendRequest(user);
                        break;
                    case 2:
                        getUserDetails();
                        loginPage.options();
                        break;
                    case 0:
                        break WHILE;
                }
            } catch (Exception e) {
                System.out.println("Enter Correct Option : ");
            }
        }
    }

    private void suggessions(User user) {
        for (Map.Entry<User, Boolean> entry : user.getFriendList().entrySet()) {
            if (!entry.getValue())
                System.out.println(entry.getKey().getName());
        }
    }

    private void friendRequest(User user) {
    }

    private void personalFeed(User user) {
        for (String feed : user.getPersonalFeed())
            System.out.println(feed);
    }

    private void profile(User user) {

        System.out.println(" ---------------------------------");
        System.out.printf("|             %-20s|%n", "Profile");
        System.out.println(" ---------------------------------");
        System.out.printf("| %-8s: %-22s|%n| %-8s: %-22s|%n| %-8s: %-22s|%n| %-8s: %-22s|%n",
                "Name ", user.getName(), "Age ", user.getAge(),
                "Email ", user.getEmail(), "Bio ", user.getBio());
        System.out.println(" ---------------------------------");
    }

    private void getUserDetails() {
        System.out.print("Enter your Name : ");
        String name = scan.next();
        System.out.print("Enter your age : ");
        byte age = scan.nextByte();
        System.out.println("Enter new Username : ");
        String userName = scan.next();
        System.out.println("Enter your Password : ");
        String password = scan.next();
        System.out.println("Enter new Confirm password : ");
        String confirmPassword = scan.next();
        if (password.equals(confirmPassword)) register(name, age, userName, password, confirmPassword);
    }

    private String[] getLoginDetails() {
        System.out.println("Enter your USERNAME : ");
        String userName = scan.next();
        System.out.println("Enter your PASSWORD : ");
        String password = scan.next();
        return new String[]{userName, password};
    }
}