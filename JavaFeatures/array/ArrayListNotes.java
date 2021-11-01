import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
public class ArrayListNotes {
    // 1. 翻转array List
    public static List<Integer> reverseList(List<Integer> list) {
        Collections.reverse(list); // We can make use of the In-built Collections.reverse() method for reversing an arraylist. It takes a list as an input parameter and listurns the reversed list.
        return list;
    }

    // 2. arrayList 转 array
    public static int[] listToIntArray(List<Integer> list) {
        int[] ret =list.stream().mapToInt(i -> i).toArray(); // Using streams API of collections in java 8 to convert to array of primitive int type
        System.out.println("arrayList to array" + Arrays.toString(ret));
        return ret;
    }

    // 3. lambda sort, arraylist 使用Collections， array使用Arrays
    // 注意comparator 必须对object使用。6
    public static void listSort(List<Integer> list) {
        // 1. Collections sort ArrayList
        Collections.sort(list, (a, b) -> b - a); // decreasing sort
        System.out.println("ArrayList customer sort" + list);

        // ArrayList -> int[] -> Integer[]
        // int[] 无法使用comparator排序，因为comparator排序是对object使用的。
        int[] arr = listToIntArray(list);
        Integer[] integers = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integers[i] = arr[i];
        }

        // 2. Arrays sort Integers[] 
        Arrays.sort(integers, (a, b) -> b - a);
        System.out.println("integers customer sort" + Arrays.toString(integers));


        // 3. Comparator sort
        Arrays.sort(
            integers,
            new java.util.Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {// why need final here?
                    return a - b;
                }
            });

        System.out.println("integers comparator customer sort: " + Arrays.toString(integers));

        // 4. compareTo
        Comparator<Integer> CustomerSort = (Integer a, Integer b) -> a.compareTo(b);
        Arrays.sort(integers, CustomerSort);
        System.out.println("integers comparator customer sort version 2: " + Arrays.toString(integers));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        reverseList(list);
        listToIntArray(list);

        list.add(9);
        list.add(-2);
        listSort(list);
    }
}
