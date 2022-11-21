import java.util.Scanner;

public class LongestBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
//
//        String str = scan.next();
//        int strCount = count(str);
//        for (int i = 0; i < strCount; i++) {
//            if (!stack.isEmpty() && str.charAt(stack.peek()) == '(' && str.charAt(i) == ')')
//                stack.pop();
//            else
//                stack.push(i);
//        }
//
//
//        System.out.println(strCount - stack.size);


    }

    private static int count(String str) {
        int strCount = 1;
        try {
            for (strCount = 1; ; strCount++) {
                str.charAt(strCount);
            }
        } catch (StringIndexOutOfBoundsException e) {
            return strCount;
        }
    }
}
