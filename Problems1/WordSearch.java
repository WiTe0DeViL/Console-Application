import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the matrix : ");
        int n = scan.nextInt();
//        char[][] charArray = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                charArray[i][j] = scan.next().charAt(0);
//            }
//        }
        char[][] charArray = {
                {'h', 'o', 'l', 'z'},
                {'a', 'l', 'o', 'o'},
                {'a', 'b', 'c', 'h'},
                {'o', 'k', 'j', 'o'}};
        System.out.print("Enter the string : ");
        String string = scan.next();
        boolean flag = true;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (string.charAt(0) == charArray[row][col] && isPresent(charArray, string, 0, row, col)) {
                    System.out.println(flag);
                    flag = false;
                    break;
                }
            }
        }
        if (flag)
            System.out.println(!flag);
    }

    static boolean wordFound;

    private static boolean isPresent(char[][] charArray, String string, int index, int row, int col) {
        if (string.length() == index)
            return true;

        if (row >= charArray.length ||
                col >= charArray[0].length ||
                index >= string.length())
            return false;

        if (charArray[row][col] == string.charAt(index) && !wordFound) {
            return isPresent(charArray, string, index + 1, row, col + 1) ||
                    isPresent(charArray, string, index + 1, row + 1, col);
        }

        return wordFound;
    }
}