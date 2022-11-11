package Evolution2;

import java.util.HashMap;
import java.util.Scanner;

public class kTimesInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.print("Enter the size of array : ");
        int n = scan.nextInt();
        System.out.print("Enter the k : ");
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + i + " index element : ");
            arr[i] = scan.nextInt();
        }

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) == k) {
                System.out.println(i);
                break;
            }
        }
    }
}
