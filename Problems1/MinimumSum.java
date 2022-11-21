import java.util.HashMap;
import java.util.Scanner;

public class MinimumSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = scan.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        System.out.println("Enter the elements of array1 : ");
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + " element : ");
            arr1[i] = scan.nextInt();
            if (arr1[i] < min1) {
                map.put(i, arr1[i]);
                min1 = arr1[i];
            }
        }
        System.out.println("Enter the elements of array2 : ");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + " element : ");
            arr2[i] = scan.nextInt();
            if (arr2[i] < min2 && (!map.containsKey(i) || map.get(i) != arr2[i])) {
                min2 = arr2[i];
            }
        }
        System.out.println(min1 + " " + min2);

    }
}
