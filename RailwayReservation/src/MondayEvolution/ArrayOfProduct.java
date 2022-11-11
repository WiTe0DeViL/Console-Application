package MondayEvolution;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOfProduct {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of an array : ");
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            System.out.print("Enter " + index + " index value");
            array[index] = scan.nextInt();
        }

        int prod = 1;
        boolean zero = false;
        int zeroCount = 0;
        for (int j : array)
            if (j != 0)
                prod *= j;
            else {
                zero = true;
                zeroCount++;
            }

        for (int i = 0; i < array.length; i++) {
            if (!zero) {
                array[i] = prod / array[i];
            } else {
                if (array[i] != 0 || zeroCount > 1)
                    array[i] = 0;
                else
                    array[i] = prod;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
