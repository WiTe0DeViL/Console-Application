package bankConsoleApplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingProcess {
    private final Scanner input = new Scanner(System.in);
    public static final ArrayList<User> userList = new ArrayList<>();

    void processing() {
        validUser();
        boolean cIDisPresent = false;
        System.out.print("\nEnter your Customer Id : ");
        while (!cIDisPresent) {
            String userCID = input.next();
            for (User user : userList) {
                if (user.getCustomerId().equals(userCID)) {
                    displayUserDetails(user);
                    Options(user);
                    cIDisPresent = true;
                }
            }
            if (!cIDisPresent) {
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
            processing();
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
                } else if (validUser == 2) {
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
                displayUserDetails(newUser);
            } else System.out.println("Mismatch Password!");
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch!");
        }
    }

    public void displayUserDetails(User newUser) {
        System.out.println("\n----------------------------------------");
        System.out.printf("|%-15s|  %-20s|\n", "Name", newUser.getName());
        System.out.printf("|%-15s|  %-20s|\n", "Age", newUser.getAge());
        System.out.printf("|%-15s|  %-20s|\n", "AccountNumber", newUser.getAccountNumber());
        System.out.printf("|%-15s|  %-20s|", "Customer ID", newUser.getCustomerId());
        System.out.println("\n----------------------------------------");
    }

    private void Options(User currentUser) {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("\n---------------------------");
                System.out.printf("|%-25s|%n|%-25s|%n|%-25s|%n|%-25s|%n|%-25s|%n|%-25s|%n|%-25s|%n|%-25s|%n",
                        "1.UserInfo", "2.Withdraw", "3.Deposit",
                        "4.Statement", "5.Previous Transaction",
                        "6.Money Transfer", "7.Balance Enquiry", "8.Exit");
                System.out.println("---------------------------");
                System.out.print("\nEnter the option : ");
                int option = input.nextInt();
                while (option > 8 || option <= 0) {
                    System.out.println("\nEnter Correct Option");
                    option = input.nextInt();
                }
                switch (option) {
                    case 1:
                        displayUserDetails(currentUser);
                        break;
                    case 2:
                        System.out.print("\nEnter the amount to Withdraw : ");
                        int amount = input.nextInt();
                        while (amount <= 0) {
                            System.out.println("\nPlease Give a valid amount");
                            amount = input.nextInt();
                        }
                        if (currentUser.withdraw(amount)) System.out.println("\nWithdraw Successful");
                        if (amount == 0) displayBalance(currentUser);
                        break;
                    case 3:
                        System.out.print("\nEnter amount to deposit : ");
                        currentUser.deposit();
                        displayBalance(currentUser);
                        break;
                    case 4:
                        if (currentUser.transactionHistory.size() == 0) {
                            System.out.println("----------------------------------");
                            System.out.printf("|%-32s|%n", "       No Transactions Yet      ");
                            System.out.println("----------------------------------");
                        } else {
                            System.out.println("--------------------------------------------");
                            System.out.printf("|%-32s|%n", "        Your Transactions Statement       ");
                            System.out.println("--------------------------------------------");
                            for (String transactions : currentUser.transactionHistory)
                                System.out.printf("|%-42s|\n", transactions);
                            System.out.println("--------------------------------------------");
                        }
                        break;
                    case 5:
                        if (currentUser.transactionHistory.size() == 0) {
                            System.out.println("----------------------------------");
                            System.out.printf("|%-32s|%n", "       No Transactions Yet      ");
                            System.out.println("----------------------------------");
                        } else
                            System.out.println("Your last transaction is " + currentUser.transactionHistory.peek());
                        break;
                    case 6:
                        System.out.print("Enter another users Account Number : ");
                        User user2 = new User();
                        AccNUM:
                        while (true) {
                            String anotherUserAccNo = new Scanner(System.in).next();
                            for (User users : userList) {
                                if (users.getAccountNumber().equals(anotherUserAccNo) && !currentUser.getAccountNumber().equals(anotherUserAccNo)) {
                                    user2 = users;
                                    break AccNUM;
                                }
                                if (users.equals(currentUser)) {
                                    System.out.println("Don't enter same user account number");
                                    System.out.println("Enter a valid account number : ");
                                }
                            }
                        }
                        System.out.println("\nEnter amount to be transferred : ");
                        int amountTransfer = 0;
                        boolean isVerified = false;
                        AMNT_WHILE:
                        while (true) {
                            amountTransfer = new Scanner(System.in).nextInt();
                            if (amountTransfer <= 10000 && amountTransfer > 0 && currentUser.getMoney() != 0) {
                                isVerified = true;
                                break AMNT_WHILE;
                            } else if (amountTransfer > 10000 || amountTransfer <= 0) {
                                System.out.print("Transfer amount limit should be 10,000!" + "\nPlease enter valid amount : ");
                            } else {
                                System.out.print("Insufficient Fund \nAccount balance is : "
                                        + currentUser.getMoney());
                                break;
                            }
                        }
                        if (isVerified)
                            currentUser.moneyTransfer(user2, amountTransfer);
                        break;
                    case 7:
                        System.out.printf("\nAccount Balance : %.2f", currentUser.getMoney());
                        break;
                    case 8:
                        flag = false;
                        return;
                    default:
                        System.out.println("\nPlease give a Valid Input");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nSelect Correct Option");
            }
        }
    }


    private void displayBalance(User user) {
        try {
            System.out.print("\n1.Balance\n2.Not Necessary\n\nOptions : ");
            int option = new Scanner(System.in).nextInt();
            if (option > 2 || option <= 0) throw new IndexOutOfBoundsException();
            if (option == 1) System.out.printf("\nBalance %.2f", user.getMoney());
            else return;
        } catch (InputMismatchException e) {
            System.out.println("\nGive an integer input");
            displayBalance(user);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nGive Correct Option");
            displayBalance(user);
        }
    }
}
