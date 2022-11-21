import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class IntToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Integer> binaryTable = new HashMap<>();
        System.out.print("Enter the number : ");
        int n = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        char[] charArray = new char[sb.length()];
        int ind = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0')
                charArray[ind++] = '1';
            else
                charArray[ind++] = '0';
        }
        int sum = 0;
        int bin = 1;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == '1')
                sum += bin;
            bin *= 2;
        }
        System.out.print(sum + "  (");
        print(charArray);
        System.out.print(")");
    }

    private static void print(char[] charArray) {
        for (char ch : charArray)
            System.out.print(ch);
    }
}
