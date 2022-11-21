package bankConsoleApplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageUser {
    private final Scanner input = new Scanner(System.in);
    public static final ArrayList<User> userList = new ArrayList<>();

    ViewUserOptions viewUserOptions;

    void isValidUser() {
        viewUserOptions = new ViewUserOptions();
        validUser();
        boolean customertIDisPresent = false;
        System.out.print("\nEnter your Customer Id : ");
        while (!customertIDisPresent) {
            String userCID = input.next();
            for (User user : userList) {
                if (user.getCustomerId().equals(userCID)) {
                    viewUserOptions.displayUserDetails(user);
                    viewUserOptions.Options(user);
                    customertIDisPresent = true;
                }
            }
            if (!customertIDisPresent) {
                System.out.print("\nEnter a Valid Customer ID : ");
            }
        }
        continueProcess();
    }

    private void continueProcess() {
        System.out.println("\nDo you want continue again");
        System.out.println("\n1.Yes\n2.NO");
        System.out.print("\nSelect option : ");
        if (input.nextInt() == 1)
            isValidUser();
        else {
            System.out.println(" ====================================");
            System.out.printf("|       %-27s |%n", "Have a Nice Day");
            System.out.println(" ====================================");
        }
    }

    private void validUser() {
        System.out.println("\n1.New User\n2.Existing User\n");
        System.out.print("Enter your option : ");
        boolean flag = true;
        while (flag) {
            try {
                int validUser = new Scanner(System.in).nextInt();
                if (validUser > 2 || validUser <= 0) throw new IndexOutOfBoundsException();
                if (validUser == 1) {
                    flag = false;
                    createUser();
                } else {
                    return;
                }
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("\nSelect Correct Option");

            }
        }
    }

    private void createUser() {
        System.out.print("\nEnter your name : ");
        String name = input.next();
        while (!name.matches("^[A-Za-z]{2,20}$")) {
            System.out.print("\nEnter a valid name : ");
            name = input.next();
        }
        System.out.print("\nEnter your age : ");
        byte age = 0;
        boolean validAge = false;
        while (!validAge) {
            try {
                age = new Scanner(System.in).nextByte();
                if (age < 18) {
                    System.out.println("\nSorry your below 18, " +
                            "so you not eligible for this account");
                    System.out.print("\nEnter Correct age : ");
                }
                if (!(age < 100)) {
                    System.out.print("\nEnter correct age : ");
                }
                if (age >= 18 && age < 120) validAge = true;
            } catch (InputMismatchException e) {
                System.out.print("\nEnter valid age : ");
            }
        }
        System.out.println("Enter your email : ");
        try {
            String email = input.next();
            System.out.println("Enter your password : ");
            String password1 = input.next();
            System.out.println("Re-enter your password : ");
            String password2 = input.next();
            if (password1.equals(password2)) {
                User newUser = new User(name, (int) age, email, password1);
                userList.add(newUser);
                viewUserOptions.displayUserDetails(newUser);
            } else System.out.println("Mismatch Password!");
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch!");
        }
    }


}
