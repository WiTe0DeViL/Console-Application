import java.util.HashMap;

public class Hash {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String i : new String[]{"car", "david", "vinoth", "dravid", "car", "ball", "apple", "air", "air", "apple", "air", "aalgebra", "alagu"}) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println(map);
    }
}
