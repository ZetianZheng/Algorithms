/**
 * 先排序，再利用滑动窗口找i~i+len-4位置的最小amplitude值。
 * O(nlogn)
 */
class v1 {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len <= 4)
            return 0;
        // System.out.println(Arrays.toString(nums));
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) { // 滑动窗口 取amplitude最小值的窗口
            int end = i + len - 4;
            // System.out.println(nums[end] + " " + nums[i]);
            minGap = Math.min(minGap, nums[end] - nums[i]);
        }
        
        return minGap;
    }
}