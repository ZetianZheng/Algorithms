class V2 {
    public boolean validPalindrome(String s) {
        // 更加通用的k个删除模板。
        // 使用递归加双指针，出现分歧的时候递归处理，要不左边，要不右边，
        // 退出条件是当deleteCount大于要求的k
        // 时间复杂度：O(n) ? 
        return validate(s, 1, 0, s.length() - 1);
    }
    
    public boolean validate(String s, int deleteCount, int l, int r) {
        if (deleteCount < 0) 
            return false;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return validate(s, deleteCount - 1, l + 1, r) || validate(s, deleteCount - 1, l, r - 1);
            }    
        }
        
        return true;
    }
}