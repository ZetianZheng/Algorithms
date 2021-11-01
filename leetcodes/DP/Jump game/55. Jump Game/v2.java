class v2 {
    public boolean canJump(int[] nums) {
        // greedy right most > n - 1 就可以了， O(n)
        int rightmost = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= rightmost) { // i 是当前可到达的地方。
                rightmost = Math.max(rightmost, nums[i] + i);  // 更新最远可到达的地方。  
            }
        }
        
        return rightmost >= nums.length - 1;
    }
}