import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String word = scan.next();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (set.add(word.charAt(i)))
                System.out.print(word.charAt(i));
        }

    }
}
