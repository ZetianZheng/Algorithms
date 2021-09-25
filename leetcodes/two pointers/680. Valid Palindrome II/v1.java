class V1 {
    public boolean validPalindrome(String s) {
        // 因为只删除一个字符，所以我们发现第一个不一样的字符的时候, 需要进行二次判断看之后的是否都一样。
        // 一开始没有进行二次判断所以会忽略掉可能性：
        // 可能性一共两种，要不删除左边的，要不删除右边的。
        // 时间复杂度：O(n)，空间复杂度 O(1)
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
                l++;
                r--; 
        }
        
        return subPalindrome(s, l + 1, r) || subPalindrome(s, l, r - 1);
    }
    
    public boolean subPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) 
                return false;
            l++;
            r--;
        }
        
        return true;
    }
}