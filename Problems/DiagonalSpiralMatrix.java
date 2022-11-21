import java.util.Arrays;

public class DiagonalSpiralMatrix {
    public static void main(String[] args) {
        int n = 6;
        int[][] matrix = new int[n][n];
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int value = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int row = rowStart, col = colStart; row <= rowEnd && col <= colEnd; row++, col++) {
                matrix[row][col] = value++;
            }
            rowEnd--;
            colStart++;

            if (rowStart <= rowEnd && colStart <= colEnd) {
                for (int row = rowEnd; row >= 0; row--) {
                    matrix[row][colEnd] = value++;
                }
                rowEnd--;
                colEnd--;
            }

            if (rowStart <= rowEnd && colStart <= colEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    matrix[rowStart][col] = value++;
                }
//                colEnd--;
                rowStart++;
                colStart++;
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2d  ", matrix[i][j]);
            }
            System.out.println();
        }
        patternFirstHalf(3);
    }


    public static void series34() {
        int n = 11;
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

    public static void alternateSorting(int[] input) {
        int maxElement = input[input.length - 1] + 1;
        int minIndex = 0;
        int maxIndex = input.length - 1;
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                input[i] += (input[maxIndex--] % maxElement) * maxElement;
            } else {
                input[i] += (input[minIndex++] % maxElement) * maxElement;
            }
        }
        for (int i = 0; i < input.length; i++) {
            input[i] /= maxElement;
        }
        System.out.println(Arrays.toString(input));
    }

    public static void threeFourSeries1() {
        int n = 12;
        int[] series = new int[n];
        series[0] = 3;
        series[1] = 4;
        int i = 2;
        int j = 0;
        while (i < n) {
            series[i++] = series[j] * 10 + series[0];
            series[i++] = series[j] * 10 + series[1];
            j++;
        }
        for (int k = 0; k < n; k++) {
            System.out.print(series[k] + " ");
        }
    }


    public static void longestPrefix() {
        String[] input = {"flower", "flow", "fly"};
        checkForLongestCommonPrefix(input);
    }

    public static void checkForLongestCommonPrefix(String[] input) {

        String lcp = input[0];

        for (int index = 1; index < input.length; index++) {
            int j = 0;
            while (j < input[index].length() && lcp.charAt(j) == input[index].charAt(j) && j < lcp.length()) {
                j++;
            }
            if (j == 0) {
                lcp = " ";
            } else {

                lcp = lcp.substring(0, j);
            }
        }

        System.out.println(lcp);
    }


    public static void main() {

        int input = 5;
        for (int line = 1; line <= input; line++) {
            int val = (line - 1) * input + 1;
            for (int cnt = 1; cnt <= (input - line); cnt++) {
                System.out.print("   ");
            }
            for (int cnt = 1; cnt <= input; cnt++) {
                System.out.printf("%2d ", val++);
            }
            System.out.println();
            line++;

            val = input * line;
            for (int cnt = 1; cnt <= (input - line) && line <= input; cnt++) {
                System.out.print("   ");
            }

            for (int cnt = 1; cnt <= input && line <= input; cnt++) {
                System.out.printf("%2d ", val--);
            }
            System.out.println();

        }
    }

    public static void patternFirstHalf(int input) {

        for (int row = 1; row <= (input + 1); row++) {
            int val = 0;
            for (int col = 1; col <= (row * 2) - 1; col++) {

                if (col == 1 || col == (row * 2) - 1) {
                    System.out.print("* ");
                } else {
                    if (col <= ((row * 2) - 1) / 2 + 1) {
                        System.out.print(++val + " ");
                    } else {
                        System.out.print(--val + " ");
                    }

                }
            }
            System.out.println();
        }

        secondHalf(input);
    }

    public static void secondHalf(int input) {


        for (int row = input; row >= 0; row--) {
            int val = 0;
            for (int col = 1; col <= (row * 2) - 1; col++) {

                if (col == 1 || col == (row * 2) - 1) {
                    System.out.print("* ");
                } else {
                    if (col <= ((row * 2) - 1) / 2 + 1) {
                        System.out.print(++val + " ");
                    } else {
                        System.out.print(--val + " ");
                    }

                }
            }
            System.out.println();
        }
    }
}

