package Bhavya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your option : ");
        WHILE:
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int option = sc.nextInt();
                if (option > 3 || option < 1) throw new IndexOutOfBoundsException();
                switch (option) {
                    case 1:
                        System.out.println("You pressed One");
                        break;
                    case 2:
                        System.out.println("you pressed Two");
                        break;
                    case 3:
                        break WHILE;
                }
            } catch (InputMismatchException e) {
                System.out.println("Your input is Mismatched");
                System.out.print("Enter correct option : ");
            } catch (IndexOutOfBoundsException e) {
                System.out.print("Enter valid input : ");
            }
        }
    }
}
