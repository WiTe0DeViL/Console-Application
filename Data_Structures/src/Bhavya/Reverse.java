package Bhavya;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        String str = "BhavyaSri";
        char[] str_array = str.toCharArray();
        int start = 0, end = str_array.length - 1;
        while (start <= end) {
            char temp = str_array[start];
            str_array[start] = str_array[end];
            str_array[end] = temp;
            start++;
            end--;
        }
        System.out.println(new String(str_array));
    }
}