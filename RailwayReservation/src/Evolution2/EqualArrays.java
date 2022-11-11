package Evolution2;

import java.util.HashMap;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = scan.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        System.out.println("Enter element of Array A");
//        Array A
        for (int i = 0; i < size; i++) {
            System.out.print("Enter " + i + " index element : ");
            int val1 = scan.nextInt();
            map.put(val1, map.getOrDefault(val1, 0) + 1);
        }
        System.out.println("Enter element of Array B");
//        Array B
        for (int i = 0; i < size; i++) {
            System.out.print("Enter " + i + " index element : ");
            int val2 = scan.nextInt();
            map.put(val2, map.get(val2) - 1);
        }
        for (Integer values : map.values()) {
            if (values != 0) {
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println(false);
        else
            System.out.println(true);
    }
}
