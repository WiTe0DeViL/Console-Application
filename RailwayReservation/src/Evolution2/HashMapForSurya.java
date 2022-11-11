package Evolution2;

import java.util.HashMap;

public class HashMapForSurya {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr = {1,1,1,1,11,2,2,2,2,3,4,4,53,45,456,345,34,53,45};

        for (int i: arr)
            map.put(i,map.getOrDefault(i,0)+1);

        System.out.println(map);
    }
}
