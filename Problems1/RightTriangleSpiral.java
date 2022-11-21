import java.util.Arrays;
import java.util.Scanner;

public class RightTriangleSpiral {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = scan.nextInt();
        int[][] arr = new int[n][n];
        int rowLower = 0;
        int rowUpper = n - 1;
        int colLower = 0;
        int colUpper = n - 1;
        int val = 1;
        while (rowLower <= rowUpper && colLower <= colUpper) {
            for (int i = rowLower, j = colLower; i <= rowUpper && j <= colUpper; i++, j++) {
                arr[i][j] = val++;
            }

            rowUpper--;
            colLower++;

            if (rowLower <= rowUpper && colLower <= colUpper) {
                for (int i = rowUpper; i >= rowLower; i--) {
                    arr[i][colUpper] = val++;
                }
            }
            colUpper--;
            rowUpper--;
            if (rowLower <= rowUpper && colLower <= colUpper) {
                for (int i = colUpper; i >= colLower; i--) {
                    arr[rowLower][i] = val++;
                }
            }
            rowLower++;
            colLower++;
        }

        displayArray(arr);

    }

    private static void displayArray(int[][] arr) {
        for (int[] x : arr) {
            for (int y : x) {
                if (y != 0)
                    System.out.printf("%3d", y);
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }
}
