class v1 {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) { // 保证a的长度大于b
            String temp = a;
            a = b;
            b = temp;
        }
            
        int carry = 0;
        int alen = a.length(), blen = b.length();
        
        int ai = alen - 1;
        int bi = blen - 1;
        String ans = "";
        
        while(bi >= 0) {
            int sum = (int)(a.charAt(ai) - '0') + (int)(b.charAt(bi) - '0') + carry; // sum 只有四个可能，0，1，2，3
            ans = sum % 2 + ans; // 本位
            carry = sum / 2; // 进位
            ai--;
            bi--;
        }
        
        while (ai >= 0) {
            int sum = (int)(a.charAt(ai) - '0') + carry;
            ans = sum % 2 + ans;
            carry = sum / 2;
            ai--;
        }
        
        if (carry != 0)
            ans = carry + ans;
        return ans;
    }
}

