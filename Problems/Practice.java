import java.util.*;
import java.util.Stack;


public class Practice {
    public static void main(String[] args) {
        String input = "bcabcab";
        System.out.println(longestNonRepeatingSubString(input));

    }

    static int[] climbingTheLeader(int[] normalPlayerScore, int[] alice) {
        int x = normalPlayerScore.length;
        int y = alice.length;

        int[] result = new int[x];
        int[] ranks = new int[y];

        ranks[0] = 1;

        for (int i = 1; i < x; i++) {
            if (normalPlayerScore[i] == normalPlayerScore[i - 1]) {
                ranks[i] = ranks[i - 1];
            } else {
                ranks[i] = ranks[i - 1] + 1;
            }
        }
        for (int i = 0; i < y; i++) {
            int aliceScore = alice[i];
            if (aliceScore > normalPlayerScore[i]) {
                result[i] = 1;
            } else if (aliceScore < normalPlayerScore[i - 1]) {
                result[i] = ranks[x - 1] + 1;
            } else {

            }
        }
        return result;
    }

    static int binarySearch(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key && key < a[mid - 1]) {
                return mid;
            } else if (a[mid] > key && key > a[mid + 1]) {
                return mid + 1;
            } else if (a[mid] > key) {
                end = mid + 1;
            } else if (a[mid] < key) {
                start = mid - 1;
            }

        }
        return -1;
    }


    public static void population() {
        int[][] populationRange = {{1900, 1903}, {1923, 1945}, {1935, 1948}, {1926, 1932}, {1961, 1982}, {1985, 1989}, {1922, 1937}, {1957, 1972}, {1976, 1999}, {1970, 2000}};

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < 10; row++) {
            int start = populationRange[row][0];
            int end = populationRange[row][1];
// System.out.println(start+" "+end);
            for (int index = start; index <= end; index++) {
                if (map.containsKey(index)) {
                    map.put(index, map.get(index) + 1);
                    if (max < map.get(index)) {
                        max = map.get(index);
                    }
                } else {
                    map.put(index, 1);
                    if (max < map.get(index)) {
                        max = map.get(index);
                    }
                }
            }
        }

// System.out.println(countPopulation);
// System.out.println(max);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());
            }

        }


    }


    public static void populationSum() {
        String[] onesPlace = {" ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String[] twosPlace1 = {" ", "eleven ", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String[] twosPlace2 = {" ", " ", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] hundredsPlace = {" ", "hundred", "two Hundred", "three Hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};

        int number = 888;
        int place = 100;
        int count = 0;
        while (number != 0) {
            int digit = number / place;
            if (place == 100) {
                System.out.print(hundredsPlace[digit] + " " + "and");
            } else if (place == 10) {
                if (digit == 1) {
                    digit = number % place;
                    place = place / 10;

                    System.out.print(" " + twosPlace1[digit]);
                    break;
                } else if (digit == 0) {
                    System.out.print(onesPlace[number]
                    );
                    break;
                } else {
                    System.out.print(" " + twosPlace2[digit]);
                }
            } else {
                System.out.print(" " + onesPlace[digit]);
            }
            number = number % place;
// System.out.print(place+" "+number);
            place = place / 10;
            count++;
        }
// System.out.println(count);
    }

    public static List<Integer> absolute(int n, int k) {
        List<Integer> result = new ArrayList<>();
        result.add(-1);
        if (k != 0 && ((n / 2) % k) != 0) {
            return result;
        }
        int substitute = k;
        for (int index = 1; index < 2 * k + 1; index++) {
            result.add(index, index + substitute);
            if (result.get(index) == 2 * k && index <= n + 1) {
                substitute -= (2 * substitute);
            }
        }
        int targetIndex;
        for (int index = (2 * k + 1); index < n + 1; index++) {
            if ((2 * k) == 0) {
                result.add(index, index);
            } else {
                targetIndex = index - (2 * k);
                result.add(index, result.get(targetIndex) + (2 * k));
            }
        }
        result.remove(0);
        return result;
    }

    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if (s == null)
            return null;
        if (s.length() == 1)
            return s;
        if (numRows == 1)
            return s;

        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + step) {
                    sb.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    if (flag) {
                        j = j + step1;
                    } else
                        j = j + step2;

                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rowSt = 0;
        int rowEnd = matrix.length - 1;

        int colSt = 0;
        int colEnd = matrix[0].length - 1;

        while (rowSt <= rowEnd && colSt <= colEnd) {

            for (int col = colSt; col <= colEnd; col++) {
                ans.add(matrix[rowSt][col]);
            }
            rowSt++;

            for (int row = rowSt; row <= rowEnd; row++) {
                ans.add(matrix[row][colEnd]);
            }
            colEnd--;

            if (rowSt <= rowEnd) {
                for (int col = colEnd; col >= colSt; col--) {
                    ans.add(matrix[rowEnd][col]);
                }

            }
            rowEnd--;

            if (colSt <= colEnd) {
                for (int row = rowEnd; row >= rowSt; row--) {
                    ans.add(matrix[row][colSt]);
                }

            }
            colSt++;
        }

        return ans;

    }

    private Node head;
    private Node tail;
    private int size;

    public Practice() {
        this.size = 0;
    }

    public static void nextGreaterLinkedList() {
        Practice greaterElementInList = new Practice();
        greaterElementInList.insertFirst(5);
        greaterElementInList.insertFirst(3);
        greaterElementInList.insertFirst(4);
        greaterElementInList.insertFirst(7);
        greaterElementInList.insertFirst(2);

        greaterElementInList.printNode(greaterElementInList.nextGreater(greaterElementInList.head));

    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void printNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node nextGreater(Node head) {
        if (head == null) {
            return head;
        }
        Node result = new Node(-1);
        Node temp = result;
        head = reverse(head);
        Stack<Integer> integerStack = new Stack<>();
        while (head != null) {
            if (integerStack.isEmpty()) {
                temp.next = new Node(0);
                integerStack.push(head.value);
            } else {
                while (!integerStack.isEmpty() && integerStack.peek() < head.value) {
                    integerStack.pop();
                }
                if (integerStack.isEmpty()) {
                    temp.next = new Node(0);
                    integerStack.push(head.value);
                } else {
                    temp.next = new Node(integerStack.peek());
                    integerStack.push(head.value);
                }
            }
            head = head.next;
            temp = temp.next;
        }
        temp = result;
        result = result.next;
        result = reverse(result);
        return result;
    }

    public static void subsequence() {
        String input = "aba";
        System.out.println(Largestsubsequence(input));
    }

    static void generatingSubseqPossible(String input, String output, List<List<String>> result) {
        if (input.isEmpty()) {
            ArrayList<String> inner = new ArrayList<>();
            inner.add(output);
            result.add(inner);
            return;
        }
        char ch = input.charAt(0);
        generatingSubseqPossible(input.substring(1), output + ch, result);
        generatingSubseqPossible(input.substring(1), output, result);
    }

    static List<List<String>> Largestsubsequence(String input) {
        List<List<String>> result = new ArrayList<>();
        generatingSubseq(input, "", result);
        findingSubSequence(result);
        return result;
    }

    static void findingSubSequence(List<List<String>> result) {
        List<String> finalResult = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < result.size(); i++) {
            for (String chcek : result.get(i)) {
                int index = 0;
                int inner = index + 2;
                boolean flag = true;
                while (index < chcek.length() - 2 && inner < chcek.length()) {
                    if (chcek.charAt(index) != chcek.charAt(inner)) {
                        flag = false;

                    }
                    index++;
                    inner++;
                }
                if (flag) {

                    if (chcek.length() > 2) {
                        finalResult.add(chcek);
                        count++;
                    }
                }
            }
        }
//        System.out.println(finalResult);
//        System.out.println(count);
    }

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static boolean inside(int N, int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static double findProb(int N, int start_x, int start_y, int step) {
        double dp[][][] = new double[N][N][step + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int s = 1; s <= step; s++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    double prob = 0;
                    for (int i = 0; i < 8; i++) {
                        int newx = x + dx[i];
                        int newy = y + dy[i];
                        if (inside(N, newx, newy)) {
                            prob += dp[newx][newy][s - 1] / 8.0;
                        }
                    }
                    dp[x][y][s] = prob;
                }
            }
        }
        return dp[start_x][start_y][step];
    }

    public static void subsequenceOfString() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(subsequence(input));

    }

    static void generatingSubseq(String input, String output, List<List<String>> result) {
        if (input.isEmpty()) {
            ArrayList<String> inner = new ArrayList<>();
            inner.add(output);
            result.add(inner);
            return;
        }
        char ch = input.charAt(0);
        generatingSubseq(input.substring(1), output + ch, result);
        generatingSubseq(input.substring(1), output, result);
    }

    static List<List<String>> subsequence(String input) {
        List<List<String>> result = new ArrayList<>();
        generatingSubseq(input, "", result);
        findingSubSequence(result);
        return result;
    }

    static void findingSubSequenceLongest(List<List<String>> result) {
        List<String> output = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < result.size(); i++) {
            for (String check : result.get(i)) {
                if (check.length() % 2 == 0) {
                    int left = 0;
                    int right = left + 2;
                    boolean flag = true;
                    while (left < check.length() - 2 && right < check.length()) {
                        if (check.charAt(left) != check.charAt(right))
                            flag = false;
                        left++;
                        right++;
                    }
                    if (flag) {
                        if (check.length() > 2) {
                            output.add(check);
                            count++;
                        }
                    }
                } else {
                    if (isPalindrome(check)) {
                        if (check.length() > 2) {
                            output.add(check);
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(output);
        System.out.println(count);
    }

    public static boolean isPalindrome(String input) {
        int i = 0;
        int j = input.length() - 1;
        while (i <= j) {
            if (i == j) {
                if (input.charAt(i) != input.charAt(0))
                    return false;
            }
            if (input.charAt(i) != input.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }


    public static int alternate(String s) {
        // Write your code here
        int NUM_LETTERS = 26;
        int length = s.length();
        if (length <= 1) {
            return 0;
        }
        int[][] pair = new int[NUM_LETTERS][NUM_LETTERS];
        int[][] count = new int[NUM_LETTERS][NUM_LETTERS];

        for (int i = 0; i < length; i++) {
            char letter = s.charAt(i);
            int letterNum = letter - 'a';

            /* Update row */
            for (int col = 0; col < NUM_LETTERS; col++) {
                if (pair[letterNum][col] == letter) {
                    count[letterNum][col] = -1;
                }
                if (count[letterNum][col] != -1) {
                    pair[letterNum][col] = letter;
                    count[letterNum][col]++;
                }
            }

            /* Update column */
            for (int row = 0; row < NUM_LETTERS; row++) {
                if (pair[row][letterNum] == letter) {
                    count[row][letterNum] = -1;
                }
                if (count[row][letterNum] != -1) {
                    pair[row][letterNum] = letter;
                    count[row][letterNum]++;
                }
            }
        }

        /* Find max in "count" array */
        int max = 0;
        for (int row = 0; row < NUM_LETTERS; row++) {
            for (int col = 0; col < NUM_LETTERS; col++) {
                max = Math.max(max, count[row][col]);
            }
        }
        return max;


    }

    public static int alternateString(String s) {
        // Write your code here
        // HashSet<Character> distinct=new HashSet<>();
        ArrayList<Character> distinct = new ArrayList<>();
        for (int index = 0; index < s.length(); index++) {
            if (!(distinct.contains(s.charAt(index)))) {
                distinct.add(s.charAt(index));
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < distinct.size() - 1; i++) {
            for (int j = i + 1; j < distinct.size(); j++) {
                char ch1 = distinct.get(i);
                char ch2 = distinct.get(j);
                String newStr = new String();
                for (int l = 0; l < s.length(); l++) {
                    if (s.charAt(l) == ch1 || s.charAt(l) == ch2) {
                        newStr = newStr + s.charAt(l);
                    }
                }
                int value = checkValid(ch1, ch2, newStr);
                if (value > max) {
                    max = value;
                }

            }
        }

        return max;


    }

    public static int checkValid(char ch1, char ch2, String str) {
        boolean flag = false;
        if (str.length() % 2 == 0) {
            int i = 0;
            int j = i + 1;
            while (i != str.length()) {
                if (str.charAt(i) == ch1 && str.charAt(j) == ch2) {
                    flag = true;
                } else {
                    flag = false;
                }
                i = i + 2;
                j = j + 2;
            }
        } else {
            int i = 0;
            int j = str.length() - 1;

            while (i <= j) {
                if (str.charAt(i) == str.charAt(j)) {
                    flag = true;
                } else {
                    flag = false;
                }
                i++;
                j--;
            }
        }
        if (flag == true) {
            return str.length();
        } else {
            return 0;
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> possible = new HashSet<>();
        permutation(possible, 0, nums.length - 1, nums);
        return new ArrayList<>(possible);
    }

    public static void permutation(Set<List<Integer>> possible, int idx, int right, int[] nums) {
        if (idx == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            possible.add(list);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            permutation(possible, idx + 1, right, nums);
            swap(nums, i, idx);
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if (!stack.isEmpty()) {
                if ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == '}' && stack.peek() == '{') || (s.charAt(i) == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    public static int longestNonRepeatingSubString(String input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int n = input.length();
        int max = 0;
//        while (right < n) {
//            if (hashMap.containsKey(input.charAt(right))) {
//                left = Math.max(hashMap.get(input.charAt(right)) + 1, left);
//            }
//            hashMap.put(input.charAt(right), right);
//            max = Math.max(max, right - left + 1);
//            right++;
//        }
        while(left <n && right < n){
            if(!set.contains(input.charAt(right))){
                set.add(input.charAt(right));
                right++;
                max = Math.max(max,right-left);
            }
            else{
                set.remove(input.charAt(left));
                left++;
            }
        }
        return max;
    }
}