package Evolution2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class FindTheLeader {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + i + " index element : ");
            array[i] = scan.nextInt();
        }
        ArrayList<Integer> answer = findTheLeader(array);
        for (int i = answer.size() - 1; i >= 0; i--)
            System.out.println(answer.get(i));
    }

    private static ArrayList<Integer> findTheLeader(int[] array) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int j = 0;
        int i = array.length - 1;
        int currMax = Integer.MIN_VALUE;
        while (i >= j) {
            if (!stack.isEmpty() && currMax <= array[i]) {
                answer.add(array[i]);
            } else {
                if (stack.isEmpty()) {
                    answer.add(array[i]);
                }
                stack.push(array[i]);

            }
            currMax = array[i] > currMax ? array[i] : currMax;
            i--;
        }
        return answer;
    }
}
