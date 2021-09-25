class v1 {
    public int divide(int dividend, int divisor) {
        // 最直观的想法就是不断的subtraction, 记录subtraction几次可以使剩下的值 < divisor, 这种做法O(n),在2^32尺度上过大。但是还需考虑negative的情况。
        // 那么可以使用位运算的方法。
        if (dividend == 0 && divisor != 0)
            return 0;
        if (divisor == 0)
            return -1;
        // Special cases: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor >0) || (dividend > 0 && divisor < 0); // 除完结果是负数的情况。
        // 位运算，每次对divisor进行乘2的操作，倍数扩大逼近边界。  
        // a = b * 2^n + m;
        // m = b * 2^n1 + m1;
        // m1....
        // ans += 2^n + 2^n1 + ...
        // 本质还是减操作，只不过利用加倍法加速算法效率到O(logn)
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
        
        int result = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)){
                shift++; // 加倍确定边界
            }
            a -= b << (shift - 1); // 对剩下的值重新继续加倍法确定边界，直到a < b
            result += 1 << (shift - 1); // 减去了2的几次方个b
        }
        
        return isNegative ? -result:result;
        
    }
}