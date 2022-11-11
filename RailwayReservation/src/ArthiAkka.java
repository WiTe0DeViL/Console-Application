import java.util.ArrayList;
import java.util.Arrays;

public class ArthiAkka {
//    public static void main(String[] args) {
//        int[] a = {3, 12, 55, 25, 6, 9, 123};
//
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++)
//                sort(a, i, j);
//        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(skip("z", "baccadh"));

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] arr = {1, 2, 3};
        int n = arr.length;
        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int l = 1 << j;
                if ((l & i) > 0) {
                    temp.add(arr[j]);
                }
            }
            list.add(temp);
        }
        System.out.println(list);
    }
//    }

    private static void sort(int[] a, int i, int j) {
        int v1 = a[i] % 10, v2 = a[j] % 10;
        if (v1 < v2) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static String skip(String p, String q) {
        if (q.isEmpty()) {
            System.out.println(p);
            return "";
        }

        char ch = q.charAt(0);
        if (ch == 'a')
            return skip(p, q.substring(1));
        else
            return ch + skip(p + ch, q.substring(1));
    }
}
