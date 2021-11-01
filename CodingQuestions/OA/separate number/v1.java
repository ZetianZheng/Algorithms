public class v1 {
    public static int separateNumber(int n) {
        int diff = Integer.MAX_VALUE;

        String s = String.valueOf(n);
        for(int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            diff = Math.min(diff, Math.abs(Integer.parseInt(left) - Integer.parseInt(right)));
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(separateNumber(1234));
        System.out.println(separateNumber(789234));
        System.out.println(separateNumber(0001));
        System.out.println(separateNumber(1111));
    }

}
