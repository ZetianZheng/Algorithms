public class v2 {
        public String addBinary(String a, String b) {
            int alen = a.length(), blen = b.length();
            int carry = 0;
            String ans = "";
            
            for (int i = alen - 1, j = blen - 1; i >= 0 || j >= 0; i--, j--) {
                int sum = 0;
                sum += (i >= 0) ? a.charAt(i) - '0' : 0;
                sum += (j >= 0) ? b.charAt(j) - '0' : 0;
                sum += carry;
                ans = sum % 2 + ans;
                carry = sum / 2;
            }
            
            if (carry != 0) 
                ans = carry + ans;
            
            return ans;
        }
}
