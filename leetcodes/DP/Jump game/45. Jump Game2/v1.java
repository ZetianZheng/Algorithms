class v1 {
    public int jump(int[] nums) {
        // dp:每一个值记录着到当前步数的最小步数，O(n ^ 2)
        // result: dp[len - 1];
        // dp[i] = Math.min(dp[i], dp[j] + 1);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n - 1];
    }
}