package bankConsoleApplication;

import java.util.Scanner;

public class Input {
    static Input input;

    private Input() {
        input = new Input();
        scanner = new Scanner(System.in);
    }

    Scanner scanner;

    public static Input getInstance() {
        return input;
    }
}
