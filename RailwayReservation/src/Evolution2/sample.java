package Evolution2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class sample {

    public static void threeFourSeriesFinder(int n) {
        int res = 0;
        int place = 1;
        while (n != 0) {
            if (n % 2 == 0) {
                res = res + place * 4;
            } else {
                res = res + place * 3;
            }
            n = (n - 1) / 2;
            place = place * 10;

        }
        System.out.print(res);
    }

    public static void main(String[] args) {


//        String str = "(((ab)";
        int n = 12;
//        threeFourSeries(n);
//        threeFourSeries(12);
//        xPattern("geeksforgeeks");
        isValidSudoku();

    }

    public static boolean isValidSudoku() {
        String[][] board = {{"5", "3", ".", ".", "7", ".", ".", ".", "."}
                , {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                , {".", "9", "8", ".", ".", ".", ".", "6", "."}
                , {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                , {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                , {".", "6", ".", ".", ".", ".", "2", "8", "."}
                , {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                , {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String curr_value = board[i][j];
                if (!curr_value.equals(".")) {
                    if (!set.add(curr_value + " row " + i) ||
                            !set.add(curr_value + " col " + j) ||
                            !set.add(curr_value + " box " + i / 3 + " - " + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void xPattern(String string) {
        for (int i = 0; i < string.length(); i++) {
            int k = string.length() - i - 1;
            for (int j = 0; j < string.length(); j++) {
                if (j == k)
                    System.out.print(string.charAt(k));
                else if (j == i)
                    System.out.print(string.charAt(i));
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void threeFourSeries(int n) {
        int[] arr = new int[n];
        int three = 3;
        int four = 4;
        arr[0] = three;
        arr[1] = four;
        int place = 10;
        int i = 2;
        int j = 0;
        while (i < n) {
            arr[i++] = arr[j] * place + three;
            arr[i++] = arr[j] * place + four;
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void makeParenthesisValid(String str) {
        StringBuilder sb = new StringBuilder(str);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                stack.push(i);
            else if (sb.charAt(i) == ')' && sb.charAt(stack.peek()) == '(')
                stack.pop();
        }

        for (int index : stack)
            sb.deleteCharAt(index);

        System.out.println(sb);
    }


}


