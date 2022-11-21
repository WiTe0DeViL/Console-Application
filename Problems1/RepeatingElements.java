import java.util.Arrays;
import java.util.Scanner;

public class RepeatingElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + " element : ");
            arr[i] = scan.nextInt();
        }
        sort(arr, n);
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                System.out.print(arr[i] + " ");
                arr[i] = 0;
            }
        }

    }

    public static void sort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
