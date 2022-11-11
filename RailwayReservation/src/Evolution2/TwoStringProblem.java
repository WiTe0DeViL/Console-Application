package Evolution2;

import java.util.*;

public class TwoStringProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first string : ");
        String s1 = scan.next();
        System.out.print("Enter the second string : ");
        String s2 = scan.next();
        System.out.println(substring(s1));
        System.out.println(substring(s2));
        scan.close();
    }

    private static int countingAnagram(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : list) {
            if (!string.equals(""))
                map.put(string, map.getOrDefault(string, 0) + 1);
        }
        int count = 0;
        for (Integer values : map.values()) {
            if (values > 1)
                count++;
        }
        return count;
    }

    private static int substring(String str) {
        int n = str.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++) {
                String tempString = str.substring(i, j);
                list.add(sortString(tempString));
            }
        return countingAnagram(list);
    }

    private static String sortString(String tempString) {
        char[] charArray = tempString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[i] > charArray[j]) {
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        return String.valueOf(charArray);

    }

}

