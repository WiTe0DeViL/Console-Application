package Bhavya;

public class LeetCode {
    public static void main(String[] args) {
        new Solution().reverseWords(new String("Let's take LeetCode contest"));
    }
}

class Solution {
    public String reverseWords(String s) {
        char[] chArray = s.toCharArray();
        int len = chArray.length, lastspace = -1;
        for (int i = 0; i <= len; i++) {
            if (i == len || chArray[i] == ' ') {
                int start = lastspace + 1;
                int end = i - 1;
                reverse(chArray, start, end);
                lastspace = i;
            }
        }

        return new String(chArray);
    }

    public void reverse(char[] chArray, int start, int end) {
        while (start <= end) {
            char temp = chArray[start];
            chArray[start] = chArray[end];
            chArray[end] = temp;
            start++;
            end--;
        }

    }
}
