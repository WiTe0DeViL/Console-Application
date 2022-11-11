package MondayEvolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepeatedSubsequence {
    public static void main(String[] args) {
        String str = "XYBYAXBY"; //  XBXAXB
//        String str = "XBXAXB"; //  XBXAXB
        ArrayList<Character> subsequence = new ArrayList<>();
        subsequence(str.toCharArray(), 0, subsequence);
        for (String s : sub)
            System.out.println(s);
        checkEqual(sub);
        System.out.println("______________________________");
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() >= 2){
                System.out.println(entry.getKey()+" "+entry.getValue());
                count++;}
        System.out.println(count);
    }

    private static void checkEqual(ArrayList<String> sub) {
        for (String s : sub) {
            if (s.length() >= 2)
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else
                    map.put(s, 1);
        }
    }

    static ArrayList<String> sub = new ArrayList<>();

    static HashMap<String, Integer> map = new HashMap<>();
    static int count;

    private static void subsequence(char[] arr, int index, ArrayList<Character> temp) {
        if (index == arr.length) {
            if (temp.size() > 0) {
                sub.add(toMakeString(temp));
                return;
            }
        } else {
            subsequence(arr, index + 1, temp);
            temp.add(arr[index]);
            subsequence(arr, index + 1, temp);
            temp.remove(temp.size() - 1);
        }
//        HashMap<String, HashMap<Character, Integer>> map = new HashMap<>();
//        for (String tempString : substrings) {
//            HashMap<Character, Integer> tempMap = new HashMap<>();
//            for (char ch : tempString.toCharArray()) {
//                tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
//            }
//            String sorted = sortString(tempString);
//            if (!map.containsKey(sorted))
//                map.put(sorted, tempMap);
//        }
//        for(HashMap<Character, Integer> tMap : map.values())
//            for(int values : tMap.values())
//                if(values>=2){
//                    count++;break;}
//        System.out.println(count / 2);


    }

    private static String toMakeString(ArrayList<Character> temp) {
        StringBuilder s = new StringBuilder();
        for (char ch : temp)
            s.append(ch);
        return s.toString();
    }

}
