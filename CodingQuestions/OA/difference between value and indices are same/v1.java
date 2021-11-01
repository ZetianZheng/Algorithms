import java.util.ArrayList;
import java.util.List;
public class v1 {
    // brute force solution O(n^2)
    private static void maximumK(List<Integer> A) {
        int len = A.size();
        int k = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if (Math.abs(i - j) == Math.abs(A.get(i) - A.get(j))){
                    k = Math.max(k, Math.abs(i - j));
                }
            }
        }

        System.out.println(k);
    }
        
    
    public static void main(String[] args) {
       List<Integer> A = new ArrayList<>();
    //    String input = "[2, 4, 6, 7, 4, 7, 2]";
       String input = "[2, 2, 2, 1]";
       input = input.substring(1, input.length() - 1);
       String[] inputs = input.split(", ");
       for (String s : inputs) {
           A.add(Integer.parseInt(s));
       }
        maximumK(A);
   }
}
