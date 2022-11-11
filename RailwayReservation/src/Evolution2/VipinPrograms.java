package Evolution2;


import java.util.*;

class VipinPrograms {
    public static void main(String[] args) {
//        removeInvalidParenthesis();
//        pattern1("suren");
//        xPattern("suren");
//        weigthSum();
//        Pattern(4);
        GFG gfg = new GFG();

    }

    private static void Pattern(int n) {
        n = 2 * n;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(4 - Math.min(Math.min(i, j), Math.min(n - i, n - j)) + " ");
            }
            System.out.println();
        }

    }

    public static void pattern1(String s) {
        int[] arr = new int[s.length()];
        int len = s.length();
        int mid = s.length() / 2;
        int tempPointer = 0;
        int tempLen = len;
        for (int i = mid; i < tempLen; i++) {
            arr[tempPointer++] = s.charAt(i);
        }
        for (int i = 0; i < mid; i++) {
            arr[tempPointer++] = s.charAt(i);
        }

        for (int i = 0; i < tempLen; i++) {
            tempPointer = 0;
            for (int j = 0; j < tempLen; j++) {
                if (j < len - 1) {
                    System.out.print(" ");
                }
                if (j >= len - 1) {
                    System.out.print((char) arr[tempPointer++]);
                }
            }
            len--;
            System.out.println();
        }
    }

    //1st program
    public static void xPattern(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int j = len - 1 - i;
            for (int k = 0; k < len; k++) {
                if (k == i || k == j)
                    System.out.print(s.charAt(j));
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


    //2nd program
    public static void weigthSum() {
        int[] arr = new int[]{10, 36, 54, 89, 12};
        Arrays.sort(arr);
        int[] wrr = new int[arr.length];
        for (int i = 0; i < 5; i++) {
            wrr[i] = 0;
            double sqr = Math.sqrt(arr[i]);
            if ((sqr * sqr) == arr[i]) {
                wrr[i] = wrr[i] + 5;
            }

            if (arr[i] % 4 == 0 && arr[i] % 6 == 0) {
                wrr[i] = wrr[i] + 4;
            }

            if (arr[i] % 2 == 0) {
                wrr[i] = wrr[i] + 3;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print("<" + arr[i] + "," + wrr[i] + ">");
        }

    }

    //3rd program
    public static void twoDimensionalArray() {
        int len = 5;
        char[] ch = {'w', 'e', 'l', 'c', 'o', 'm', 'e', 't', 'o', 'z', 'o', 'h', 'o', 'c', 'o', 'r', 'p', 'o', 'r', 'a', 't', 'i', 'o', 'n'};
        char[][] arr = new char[len][len];
        int temp = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (temp < ch.length)
                    arr[i][j] = ch[temp++];
            }
        }
        String t = "too";
        //searching

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len; j++) {
                if ((arr[i][j] == 't') && (arr[i][j + 1] == 'o') && arr[i][j + 2] == 'o') {
                    System.out.println("start index is " + i + "" + j);
                    System.out.println("end index is " + i + "" + j + 2);
                }
                if (arr[i][j] == 't' && arr[i + 1][j] == 'o' && arr[i + 2][j] == 'o') {
                    int temp1 = i + 2;
                    System.out.println("<" + i + "," + j + ">");
                    System.out.println("<" + temp1 + "," + j + ">");
                    break;
                }
            }
        }
    }

    //question no 4
    public static void validSuduko() {
        int count;
        Scanner sc = new Scanner(System.in);
        int[][] sudukoBoard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudukoBoard[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 9; i++) {
            count = 0;
            for (int j = 0; j < 9; j++) {
                count += sudukoBoard[i][j];
            }
            if (count != 45) {
                System.out.println("invalid");
                return;
            }
        }
        for (int j = 0; j < 9; j++) {
            count = 0;
            for (int i = 0; i < 9; i++) {
                count += sudukoBoard[i][j];
            }
            if (count != 45) {
                System.out.println("invalid");
                return;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        count += sudukoBoard[i * 3 + k][j * 3 + l];
                    }
                }
                if (count != 45) {
                    System.out.println("invalid");
                    return;
                }
            }
        }
        System.out.println("valid");
    }

    /*
        int[][] suduko = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1 ,9 ,8 ,3, 4 ,2 ,5 ,6 ,7},
                {8, 5 ,9 ,7 ,6 ,1 ,4 ,2, 3},
                {4 ,2 ,6 ,8 ,5 ,3 ,7 ,9 ,1},
                {7 ,1 ,3 ,9 ,2 ,4 ,8 ,5 ,6},
                {9 ,6 ,1 ,5 ,3 ,7 ,2 ,8 ,4},
                {2 ,8 ,7 ,4 ,1 ,9 ,6 ,3 ,5},
                {3 ,4 ,5 ,2 ,8 ,6 ,1 ,7 ,9},
        };
     */
    //5th question
    public static int numGrandchildren(String[][] mat, String gf) {
        if (mat == null || mat.length == 0 || gf == null || gf.length() == 0) {
            return 0;
        }

        String[][] a = {{"luke", "shaw"}, {"wayne", "rooney"},
                {"rooney", "ronaldo"}, {"shaw", "rooney"}};
        String toFind = "ronaldo";
        System.out.println(numGrandchildren(a, toFind));


        HashMap<String, ArrayList<String>> mp = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            String father = mat[i][1];
            if (!mp.containsKey(father)) {
                mp.put(father, new ArrayList<String>());
            }
            mp.get(father).add(mat[i][0]);
        }

        int num = 0;
        ArrayList<String> ls = mp.get(gf);
        for (String s : ls) {
            int k = mp.containsKey(s) ? mp.get(s).size() : 0;
            num += k;
        }
        return num;
    }

    //set 2 question 1
    public static void alternateSorting(int[] input) {
        int maxElement = input[input.length - 1] + 1;
        int minIndex = 0;
        int maxIndex = input.length - 1;
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                input[i] += (input[maxIndex--] % maxElement) * maxElement;
            } else {
                input[i] += (input[minIndex++] % maxElement) * maxElement;
            }
        }
        for (int i = 0; i < input.length; i++) {
            input[i] /= maxElement;
        }
        System.out.println(Arrays.toString(input));
    }

    //question 2
    static boolean isParenthesis(char c) {
        return ((c == '(') || (c == ')'));
    }

    static boolean isValidString(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    static void removeInvalidParenthesis() {
        String str = "(((ab)";
        StringBuilder sb = new StringBuilder(str);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                stack.push(i);
            else if (sb.charAt(i) == ')' && sb.charAt(stack.peek()) == '(')
                stack.pop();
        }

        for (int index : stack)
            sb.deleteCharAt(index);

        System.out.println(sb);
    }

    public static void threeFourSeries() {
        int n = 11;
        int res = 0;
        int place = 1;
        while (n != 0) {
            if (n % 2 == 0) {
                res = res + place * 4;
            } else {
                res = res + place * 3;
            }
            n = (n - 1) / 2;
            place = place * 10;

        }
        System.out.print(res);
    }

    public static void threeFourSeries1() {
        int n = 12;
        int[] arr = new int[n];
        arr[0] = 3;
        arr[1] = 4;
        int i = 2;
        int j = 0;
        while (i < n) {
            arr[i++] = arr[j] * 10 + arr[0];
            arr[i++] = arr[j] * 10 + arr[1];
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }
}


class GFG
{

    // A date has day 'd', month 'm' and year 'y'
    static class Date
    {
        int d, m, y;

        public Date(int d, int m, int y)
        {
            this.d = d;
            this.m = m;
            this.y = y;
        }

    };

    // To store number of days in
    // all months from January to Dec.
    static int monthDays[] = {31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31};

    // This function counts number of
    // leap years before the given date
    static int countLeapYears(Date d)
    {
        int years = d.y;

        // Check if the current year needs to be considered
        // for the count of leap years or not
        if (d.m <= 2)
        {
            years--;
        }

        // An year is a leap year if it is a multiple of 4,
        // multiple of 400 and not a multiple of 100.
        System.out.println(years / 4 - years / 100 + years / 400);
        return years / 4 - years / 100 + years / 400;
    }

    // This function returns number
    // of days between two given dates
    static int getDifference(Date dt1, Date dt2)
    {
        // COUNT TOTAL NUMBER OF DAYS BEFORE FIRST DATE 'dt1'

        // initialize count using years and day
        int n1 = dt1.y * 365 + dt1.d;

        // Add days for months in given date
        for (int i = 0; i < dt1.m - 1; i++)
        {
            n1 += monthDays[i];
        }

        // Since every leap year is of 366 days,
        // Add a day for every leap year
        n1 += countLeapYears(dt1);

        // SIMILARLY, COUNT TOTAL NUMBER OF DAYS BEFORE 'dt2'
        int n2 = dt2.y * 365 + dt2.d;
        for (int i = 0; i < dt2.m - 1; i++)
        {
            n2 += monthDays[i];
        }
        n2 += countLeapYears(dt2);

        // return difference between two counts
        return (n2 - n1);
    }

    // Driver code
    public static void main(String[] args)
    {
        Date dt1 = new Date(10, 2, 2004);
        Date dt2 = new Date(10, 3, 2022);
        System.out.println("Difference between two dates is " +
                getDifference(dt1, dt2));
    }
}

