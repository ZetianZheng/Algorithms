class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 使用前缀和O(N)，遍历可能的长度O(N), 然后滑动窗口通过前缀和取每一个长度的子和。
        // prefix:
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        
        // System.out.println(Arrays.toString(prefix));
        
        // slide window:
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int subSum = prefix[j] - prefix[j - i];
                // System.out.println(subSum);
                if (subSum % k == 0)
                    return true;
            }
        }
        
        return false;
    }
}