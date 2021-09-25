import java.math.BigInteger;
public class v3 {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2); // 0的二进制，等下比较用
        
        BigInteger ans, carry;
        
        while (y.compareTo(zero) != 0) { // compareTo == 0表示两个相等。
            ans = x.xor(y); // 没有进位的答案。
            carry = x.and(y).shiftLeft(1); // 得到进位，x和y and操作并左移1位。
            x = ans; // 继续 
            y = carry;
        }
        
        return x.toString(2);
    }
}
