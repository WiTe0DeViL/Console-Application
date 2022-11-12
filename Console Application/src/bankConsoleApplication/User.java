package bankConsoleApplication;

import java.util.*;

public class User {
    // Like IFSC KVBL1194
    private static long generatedAccountNum = 1194000000;
    private static int CiD = 0;

    int cid = 0;
    private String name = "",
            accountNumber = "",
            customerId = "";

    private int age;

    private double money;

    private String email, password;
    public Stack<String> transactionHistory = new Stack<>();

    User() {}

    User(String name, int age, String email, String password) {
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

    public void setMoney(double money) {
        this.money = money;
    }
}
