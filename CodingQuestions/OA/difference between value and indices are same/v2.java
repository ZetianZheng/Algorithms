import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class v2 {
    // brute force solution O(n^2)
    private static void maximumK(List<Integer> A) {
        int len = A.size();
        int k = Integer.MIN_VALUE;

        Map<Integer, Integer> map2 = new HashMap<>(); // A[x] + x , ind
        Map<Integer, Integer> map1 = new HashMap<>(); // A[x] - x , ind

        for (int i = 0; i < len; i++) {
            int key1 = A.get(i) - i;
            if (map1.containsKey(key1)) {
                k = Math.max(k, i - map1.get(key1));
            } else {
                map1.put(key1, i);
            }
            int key2 = A.get(i) + i;
            if (map2.containsKey(key2)) {
                k = Math.max(k, i - map2.get(key2));
            } else {
                map2.put(key2, i);
            }
        }

        System.out.println(k);
    }
        
    
    public static void main(String[] args) {
       List<Integer> A = new ArrayList<>();
       String input = "[2, 4, 6, 7, 4, 7, 2]";
    //    String input = "[2, 2, 2, 1]";
       input = input.substring(1, input.length() - 1);
       String[] inputs = input.split(", ");
       for (String s : inputs) {
           A.add(Integer.parseInt(s));
       }
        maximumK(A);
   }
}
