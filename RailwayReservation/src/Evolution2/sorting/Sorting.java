package Evolution2.sorting;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        var sorting = new MergeSort();
        int[] array = {7, 3, 1, 1, 3, 9, 5, 64, 2, 7, 10, 9, 2, 5, 4};
        sorting.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
