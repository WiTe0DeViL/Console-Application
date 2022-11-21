import java.util.Scanner;

public class RangeOfTheArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + " element : ");
            arr[i] = scan.nextInt();
            max = arr[i] > max ? arr[i] : max;
            min = arr[i] < min ? arr[i] : min;
        }

        System.out.println(max - min);
    }


}
