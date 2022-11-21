import java.util.Scanner;

public class StringRotation {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string1 : ");
        String str1 = scan.next();
        System.out.print("Enter string2 : ");
        String str2 = scan.next();
        int str1Count = count(str1);
        int str2Count = count(str2);


        if (str1Count != str2Count) {
            System.out.println(false);
            return;
        }


        char first = str1.charAt(0);

        int rotated = 0;
        for (int index = 0; index < str2Count; index++) {
            if (first != str2.charAt(index))
                rotated++;
            else
                break;
        }

        char[] str1CharArray = rotate(str1, str1Count, rotated);

        for (int index = 0; index < str1Count; index++) {
            if (str1CharArray[index] != str2.charAt(index)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);

    }


    private static char[] rotate(String str1, int size, int k) {
        char[] charArray = new char[size];
//        converting to char array
        for (int i = 0; i < size; i++)
            charArray[i] = str1.charAt(i);

        reverse(0, size - k - 1, charArray);
        reverse(size-k, size - 1, charArray);
        reverse(0, size - 1, charArray);
        return charArray;

    }

    private static void reverse(int start, int end, char[] charArray) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }

    private static int count(String str) {
        int strCount = 0;
        try {
            for (strCount = 0; ; strCount++) {
                str.charAt(strCount);
            }
        } catch (StringIndexOutOfBoundsException e) {
            return strCount;
        }
    }
}

