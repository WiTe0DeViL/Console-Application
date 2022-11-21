package bankConsoleApplication;


public class Bank {

    public static void main(String[] args) {
        new Admin();
        System.out.println("================================================");
        System.out.printf("|     %-41s|%n", "Welcome to Bank Console Application");
        System.out.println("================================================");
        new ManageUser().isValidUser();

    }


}
