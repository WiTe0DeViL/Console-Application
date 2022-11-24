package Recursion;

public class Recusive {
    public static void main(String[] args) {
        int a = 5;
         fact( a);
    }

    public static void fact( int n) {
        if (n >= 0){
            fact(n-1);
            System.out.println(n);
        }

    }
}
//
