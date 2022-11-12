package bankConsoleApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Transactions {
    public boolean withdraw(double amount, User user) {
        boolean flag = false;
        try {
            if (amount > 10000 || amount > user.getMoney()) throw new IndexOutOfBoundsException();
            if (user.getMoney() != 0 && user.getMoney() >= amount) {
                user.setMoney(user.getMoney() - amount);
                previousTransaction("Withdraw amount is " + amount, user);
                flag = true;
            }
            return flag;
        } catch (InputMismatchException e) {
            System.out.println("\nGive a valid amount");
        } catch (IndexOutOfBoundsException e) {
            if (user.getMoney() == 0) System.out.println("Your account balance is " + user.getMoney());
            else if (user.getMoney() < amount) System.out.println("\nYour account is insufficient of fund");
            else System.out.println("\nYour Exceeded Withdraw limit per day 10,000 is the Limit");
        }

        return flag;
    }

    public void deposit(User user) {

        boolean flag = false;
        while (!flag) {
            try {
                double amount = new Scanner(System.in).nextDouble();
                if (amount > 100000) throw new IndexOutOfBoundsException();
                else if (amount <= 0) throw new InputMismatchException();
                else {
                    user.setMoney(user.getMoney() + amount);
                    flag = true;
                }
                System.out.println("\nDeposited Successfully");
                previousTransaction("Deposited amount is " + amount, user);
            } catch (InputMismatchException e) {
                System.out.print("\nEnter a valid amount : ");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nYour Exceeded Deposit limit you can deposit 100000 in one transaction");
                System.out.print("Please give valid amount : ");
            }
        }
    }

    public void moneyTransfer(User anotherUser, int amountTransfer, User user) {
        user.setMoney(user.getMoney() - amountTransfer);
        anotherUser.setMoney(anotherUser.getMoney() + amountTransfer);
        System.out.println("Money Transfer Successful");
        user.transactionHistory.push(amountTransfer + " amount sent to " + anotherUser.getName());
        anotherUser.transactionHistory.push(amountTransfer + " amount received from " + user.getName());
    }

    /*
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
     */
    private void previousTransaction(String str, User user) {
        user.transactionHistory.push(str);
    }
}
