import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter matrix length : ");
        int length = scan.nextInt();

        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        System.out.print("Enter the k times to rotate : ");
        int k = scan.nextInt();

        if (k > length) {
            System.out.println("Entered rotation size is larger than matrix size");
            return;
        }
        if (k == length) {
            display(matrix);
            return;
        }

        int col = 0;
        for (int i = 0; i < k; i++) {
            int row = 0;
            while (row < length) {
                rotate(matrix, row, col, k, length);
                row++;
            }
        }

        display(matrix);

    }

    private static void display(int[][] matrix) {
        for (int[] x : matrix) {
            for (int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix, int row, int col, int k, int length) {
        int last = matrix[row][length - 1];
        for (int i = length - 1; i > col; i--) {
            matrix[row][i] = matrix[row][i - 1];
        }
        matrix[row][0] = last;
    }
}
