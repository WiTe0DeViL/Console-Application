package Bhavya;

public class Str {
    public static void main(String[] args) {
//        String[] str = new String[]{"sun", "rise", "super"};
//        for (int i = str.length-1; i >=0; i--) {
//            System.out.print((i == 0) ? str[i] : str[i] + "00");
//        }
        String[][] str = {{"a"}, {"b"}, {"c"}};
        for (String[] array : str) {
//            for (String s : array)
                System.out.println(array);
        }
    }
}
