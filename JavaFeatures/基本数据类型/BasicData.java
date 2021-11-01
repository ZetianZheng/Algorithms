public class BasicData {
    public static void main(String[] args) {
        // 1. String -> int
        String s = "123456";
        int n0 = Integer.parseInt(s);
        System.out.println("integer parseint: " + n0);

        int n1 = Integer.valueOf(s).intValue(); 
        System.out.println("String to integer to int: " + n1);

        // 2. int -> String
        int num = 123456;
        String s1 = num + "";
        String s2 = String.valueOf(num); // 不需要担心null
        // 源码： public static String valueOf(Object obj){return (obj==null)?"null":obj.toString();}
        String s3 = Integer.toString(num); // Object 的pubic方法toString(), 需保证object不为null， NullPointerException!

        System.out.println("s1: "+ s1 + "s2: " + s2 + "s3: " + s3);

    }
}
