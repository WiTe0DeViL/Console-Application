package bankConsoleApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewUserOptions {
    Transactions transactions;
    Scanner input;

    ManageUser manageUser;

    void Options(User currentUser) {
        input = new Scanner(System.in);
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
                flag = selectedOption(currentUser, option);

            } catch (InputMismatchException e) {
                System.out.println("\nSelect Correct Option");
            }
        }
    }

    User user2;

    private boolean selectedOption(User currentUser, int option) {
        transactions = new Transactions();
        manageUser = new ManageUser();
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
                if (transactions.withdraw(amount, currentUser)) System.out.println("\nWithdraw Successful");
                if (amount == 0) displayBalance(currentUser);
                break;
            case 3:
                System.out.print("\nEnter amount to deposit : ");
                transactions.deposit(currentUser);
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
                ACCOUNT_NUMBER:
                while (true) {
                    String anotherUserAccNo = new Scanner(System.in).next();
                    for (User users : ManageUser.userList) {
                        if (users.getAccountNumber().equals(anotherUserAccNo) && !currentUser.getAccountNumber().equals(anotherUserAccNo)) {
                            user2 = users;
                            break ACCOUNT_NUMBER;
                        }
                        if (currentUser.getAccountNumber().equals(anotherUserAccNo) && users.equals(currentUser)) {
                            System.out.println("Don't enter same user account number");
                            System.out.println("Enter a valid account number : ");
                            break;
                        }
                    }
                    System.out.println("Enter a valid account number : ");
                }
                System.out.println("\nEnter amount to be transferred : ");
                int amountTransfer = 0;
                boolean isVerified = false;

                while (true) {
                    amountTransfer = new Scanner(System.in).nextInt();
                    if (amountTransfer <= 10000 && amountTransfer > 0 && currentUser.getMoney() != 0) {
                        isVerified = true;
                        break;
                    } else if (amountTransfer > 10000 || amountTransfer <= 0) {
                        System.out.print("Transfer amount limit should be 10,000!" +
                                "\nPlease enter valid amount : ");
                    } else {
                        System.out.print("Insufficient Fund \nAccount balance is : "
                                + currentUser.getMoney());
                        break;
                    }
                }

                if (isVerified && user2 != null)
                    transactions.moneyTransfer(user2, amountTransfer, currentUser);
                break;
            case 7:
                System.out.printf("\nAccount Balance : %.2f", currentUser.getMoney());
                break;
            case 8:
                return false;
            default:
                System.out.println("\nPlease give a Valid Input");
        }
        return true;
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

    public void displayUserDetails(User newUser) {
        System.out.println("\n----------------------------------------");
        System.out.printf("|%-15s|  %-20s|\n", "Name", newUser.getName());
        System.out.printf("|%-15s|  %-20s|\n", "Age", newUser.getAge());
        System.out.printf("|%-15s|  %-20s|\n", "AccountNumber", newUser.getAccountNumber());
        System.out.printf("|%-15s|  %-20s|", "Customer ID", newUser.getCustomerId());
        System.out.println("\n----------------------------------------");
    }

}
