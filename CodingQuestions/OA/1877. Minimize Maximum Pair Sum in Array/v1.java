class v1 {
    public int minPairSum(int[] nums) {
        // 排序后把n大和n小配对即可 O(nlogn)
        // 可以用最大堆和最小堆优化到O(n)
        Arrays.sort(nums);
        int len = nums.length;
        int minMax = Integer.MIN_VALUE;
        for (int i = 0; i < len / 2; i++) {
            minMax = Math.max(nums[i] + nums[len - 1 - i], minMax);
        }
        return minMax;
    }
}