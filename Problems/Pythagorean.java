import java.util.Scanner;

public class Pythagorean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        boolean fl = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((arr[i] * arr[i]) + (arr[j] * arr[j]) == (arr[k] * arr[k])) {
                        System.out.print(arr[i] + " " + arr[j] + " " + arr[k]);
                        fl = true;
                    }
                }
            }
        }
        if (!fl)
            System.out.print("NONE");

    }
}
