class v1 {
    public boolean canJump(int[] nums) {
        // dp,O(n^2) 思路跟jump game 2 一样，超时
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1;i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (j + nums[j] >= i && dp[j] == true) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[n - 1];

    }
}