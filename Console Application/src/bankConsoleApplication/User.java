package bankConsoleApplication;

import java.util.*;

public class User {
    // Like IFSC KVBL1194
    private static long generatedAccountNum = 1194000000;
    private static int CiD = 0;

    int cid = 0;
    private String name = "", accountNumber = "", customerId = "";

    private int age;

    public void setMoney(double money) {
        this.money = money;
    }

    private double money;
    private String email, password;
    public Stack<String> transactionHistory = new Stack<>();

    User() {
    }

    User(String name, int age, String email, String password) {
        newUser(name, age, email, password);
    }


    public boolean withdraw(double amount) {
        boolean flag = false;
        try {
            if (amount > 10000 || amount > this.money) throw new IndexOutOfBoundsException();
            if (this.money != 0 && this.money >= amount) {
                this.money -= amount;
                previousTransaction("Withdraw amount is " + String.valueOf(amount));
                flag = true;
            }
            return flag;
        } catch (InputMismatchException e) {
            System.out.println("\nGive a valid amount");
        } catch (IndexOutOfBoundsException e) {
            if (this.money == 0) System.out.println("Your account balance is " + this.money);
            else if (this.money < amount) System.out.println("\nYour account is insufficient of fund");
            else System.out.println("\nYour Exceeded Withdraw limit per day 10,000 is the Limit");
        }

        return flag;
    }

    public void moneyTransfer(User anotherUser, int amountTransfer) {
        this.setMoney(this.getMoney() - amountTransfer);
        anotherUser.setMoney(anotherUser.getMoney() + amountTransfer);
        System.out.println("Money Transfer Successful");
        this.transactionHistory.push(String.valueOf(amountTransfer) + "amount sent to " + anotherUser.getName());
        anotherUser.transactionHistory.push(String.valueOf(amountTransfer) + "amount received from " + this.getName());
    }

    private void previousTransaction(String str) {
        this.transactionHistory.push(str);
    }

    public void deposit() {

        boolean flag = false;
        while (!flag) {
            try {
                double amount = new Scanner(System.in).nextDouble();
                if (amount > 100000) throw new IndexOutOfBoundsException();
                else if (amount <= 0) throw new InputMismatchException();
                else {
                    this.money += amount;
                    flag = true;
                }
                System.out.println("\nDeposited Successfully");
                previousTransaction("Deposited amount is " + String.valueOf(amount));
            } catch (InputMismatchException e) {
                System.out.print("\nEnter a valid amount : ");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nYour Exceeded Deposit limit " +
                        "you can deposit 100000 in one transaction");
                System.out.print("Please give valid amount : ");
            }
        }
    }

    private void newUser(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.accountNumber += ++generatedAccountNum;
        this.customerId += ++CiD;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getAge() {
        return age;
    }

    public double getMoney() {
        return this.money;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
