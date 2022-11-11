package Evolution2;

public class FrequencyAlpha {
    public static void main(String[] args) {
//        String str = "aaabbcdd";
        String str = "xyyyzzzabb";
        char[] charArray = str.toCharArray();
        int[] alph = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            alph[charArray[i] - 'a']++;
        }
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] != 0) {
                System.out.print((char) (i + 'a'));
                System.out.print(alph[i] != 1 ? alph[i] : "");
            }
        }

    }
}
