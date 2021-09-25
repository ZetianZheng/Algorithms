import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ArrayListNotes {
    // 1. 翻转array List
    public static List<Integer> reverseList(List<Integer> list) {
        Collections.reverse(list); // We can make use of the In-built Collections.reverse() method for reversing an arraylist. It takes a list as an input parameter and listurns the reversed list.
        return list;
    }

    // 2. arrayList 转 array
    public static void listToIntArray(List<Integer> list) {
        int[] ret =list.stream().mapToInt(i -> i).toArray(); // Using streams API of collections in java 8 to convert to array of primitive int type
        System.out.println(ret);
    }

    // 3. lambda sort
    public static void listSort(List<Integer> list) {
        Collections.sort(list, (a, b) -> b - a); // decreasing sort
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        reverseList(list);
        listToIntArray(list);
    }
}
