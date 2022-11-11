package MondayEvolution;

import java.util.Scanner;

public class KnightProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.print("Enter the size of the matrix : ");
//        int n = scan.nextInt();
        System.out.println(knightProbability(3, 5, 0, 0));

    }

    public static double knightProbability(int n, int k, int row, int column) {
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
        double[][][] dp = new double[n][n][k+1];

        // Initaialy for 0 steps the probability will be one
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j][0] = 1.0;

        for (int steps = 1; steps <= k; steps++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    double probability = 0.0;
                    for (int i = 0; i < 8; i++) {
                        int new_row = r + dr[i];
                        int new_col = c + dc[i];
                        if (inside(new_row, new_col, n)) {
                            probability += dp[new_row][new_col][steps - 1] / 8.0;
                        }
                    }
                    dp[r][c][steps] = probability;
                }
            }
        }
        return dp[row][column][k];
    }

    private static boolean inside(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
