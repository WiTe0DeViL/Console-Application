package Evolution2.sorting;

public class MergeSort {
    public void sort(int[] array) {
        // Recursive call base condition
        if (array.length < 2)
            return;

        // Divide the array
        int middle = array.length / 2;
        int[] left = new int[middle];

        for (int i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];

        for (int i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        //recursive call
        sort(left);
        sort(right);

        // Merging the array
        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r])
                result[k++] = left[l++];
            else
                result[k++] = right[r++];
        }

        while (l < left.length)
            result[k++] = left[l++];

        while (r < right.length)
            result[k++] = right[r++];

    }

}
