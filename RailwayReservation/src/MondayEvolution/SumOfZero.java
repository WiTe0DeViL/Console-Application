package MondayEvolution;

import java.util.*;

public class SumOfZero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of an array : ");
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < n; index++) {
            System.out.print("Enter " + index + " index value ");
            array[index] = scan.nextInt();
        }
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(array);
        for (int i = 0; i < n - 1; i++) {
            int j = 1;
            int k = n - 1;
            while (j < k) {
                ArrayList<Integer> tempArray = new ArrayList<>();
                if ((array[i] + array[j] + array[k]) == 0 && i != k && i != j) {
                    tempArray.add(array[i]);
                    tempArray.add(array[j]);
                    tempArray.add(array[k]);
                }
                if (tempArray.size() > 0) {
                    set.add(tempArray);
                }
                j++;
                k--;
            }
        }
        for (ArrayList<Integer> a : set)
            System.out.println(a);
    }

}
