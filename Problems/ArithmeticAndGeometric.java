import java.util.Scanner;

public class ArithmeticAndGeometric {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] series = new int[n];
        for (int i = 0; i < n; i++)
            series[i] = sc.nextInt();

        if (isAp(series)) {
            System.out.println("AP series : " + (series[1] - series[0] + series[n - 1]));
        } else if (isGp(series)) {
            System.out.println("GP series : " + (series[1] / series[0]) * series[n - 1]);
        }
    }

    public static boolean isAp(int[] arr) {
        int first = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != first)
                return false;
        }
        return true;
    }

    public static boolean isGp(int[] arr) {
        int first = arr[1] / arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] / arr[i] != first)
                return false;
        }
        return true;
    }
}
