public class greatCommonDivisor {
    // 欧几里得算法求最大公约数
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }


    public static void main(String[] args) {
        System.out.println(greatCommonDivisor.gcd(4,8));
    }
}
