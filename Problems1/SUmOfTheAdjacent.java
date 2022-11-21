import java.util.Scanner;

public class SUmOfTheAdjacent {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of testcases : ");
        int t = scan.nextInt();
        while (t-- > 0) {
            System.out.print("Enter the size of the array : ");
            int n = scan.nextInt();
            int[] arr = new int[n];
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            for (int index = 1; index < n - 1; index++) {
                int left = leftSum(arr, index - 1);
                int right = rightSum(arr, index + 1);
                if (left == right) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    private static int leftSum(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++)
            sum += arr[i];
        return sum;
    }

    private static int rightSum(int[] arr, int n) {
        int sum = 0;
        for (int i = n; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }
}
