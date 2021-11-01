import java.util.Arrays;
import java.util.Collections;

public class DeleteB {
    public static int deleteB(String s) {
        char[] chrs = s.toCharArray();
        int len =  chrs.length;
        for(int i = 0; i < len; i++) {
            if (chrs[i] == 'a')
                break;
            if (chrs[i] == 'b' && i == len - 1)
                return len;
        }
        int[] dpLeft = new int[len];
        int[] dpRight = new int[len];

        dpLeft[0] = chrs[0] == 'a' ? 0 : 1;
        dpRight[0] = chrs[len - 1] == 'a' ? 0 : 1;
        for (int i = 1;i < len; i++) {
            if (chrs[i] == 'a') {
                dpLeft[i] = dpLeft[i - 1];
            } else {
                dpLeft[i] = Math.min(i + 1, dpLeft[i - 1] + 2);
            }

            if (chrs[len - i - 1] == 'a') {
                dpRight[i] = dpRight[i - 1];
            } else {
                dpRight[i] = Math.min(i + 1, dpRight[i - 1] + 2);
            }
        }
        System.out.println(Arrays.toString(dpLeft));
        dpRight = reverse(dpRight);
        System.out.println(Arrays.toString(dpRight));
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            ret = Math.min(ret, dpLeft[i] + dpRight[i]);
        }

        return ret;
    }
    public static int[] reverse(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        return a;

    }
    public static void main(String[] args) {
        String input = "bbb";
        System.out.println(deleteB(input));
    }
}


class Solution {

    public static int solution(String S) {
      char[] chrs = S.toCharArray();
      int n = S.length();
      // if all the characters are b, return the String length.
      for (int i = 0; i < n; i++) {
        if (chrs[i] == 'a') {
          break;
        }
        if (chrs[i] == 'b' && i == n - 1) {
          return n;
        } 
      }
      // dp 
      int[] dpLeft = new int[n];
      int[] dpRight = new int[n];
      
      dpLeft[0] = chrs[0] == 'a' ? 0 : 1;
      dpRight[n - 1] = chrs[n - 1] == 'a' ? 0 : 1;
      
      for (int i = 1; i < n; i++){
        if (chrs[i] == 'a') {
          dpLeft[i] = dpLeft[i - 1];
        } else {
          dpLeft[i] = Math.min(dpLeft[i-1] + 2, i + 1);
        }
      }
      
      for (int i = n - 2; i >= 0; i--) {
        if(chrs[i] == 'a') {
          dpRight[i] = dpRight[i+1]; 
        } else {
          dpRight[i] = Math.min(dpRight[i+1] + 2, n - i + 1);
        }
      }
      
      int ret = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++){
        ret = Math.min(ret, dpRight[i] + dpLeft[i]);
      }
      
      return ret;
    }
  }
  
  