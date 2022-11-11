package Evolution2;

import java.util.*;

import static java.lang.Math.abs;

public class ZeroSumSubArray {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        HashMap<Integer, int[]> map = new HashMap<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
//        System.out.print("Enter the size of the array : ");
//        int n = scan.nextInt();
//        Integer[] array = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            System.out.print("Enter " + i + " index element : ");
//            array[i] = scan.nextInt();
//        }
        Integer[] array = {-1, 1, 0, 2, -1, 4};
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            int st = i + 1;
            int end = array.length - 1;
            while (st < end) {
                ArrayList<Integer> l = new ArrayList<>();

                if (array[i] + array[st] + array[end] == 0 && i != st && i != end) {
                    l.add(array[i]);
                    l.add(array[st]);
                    l.add(array[end]);
                    st++;
                    end--;
                    set.add(l);
                    System.out.println(l);
                } else if (array[i] + array[st] + array[end] < 0 && i != st && i != end)
                    st++;
                else if (array[i] + array[st] + array[end] > 0 && i != st && i != end)
                    end--;
            }
        }
        System.out.println(set);
    }

}

