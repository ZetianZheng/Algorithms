class v1 {
    public int maxProduct(int[] nums) {
        // 跟股票有点像，只不过负值可以使最小值瞬间变成最大。
        // 之前非乘法的是每次遇到负值直接可以抛弃前面所有的和，这次还需要换一个dp数组保留最小值，防止出现负值之后把最小值变为最大值。
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        int result = nums[0];
        for(int i = 1; i < n; i++) {
            max[i] = min[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            result = Math.max(max[i], result);
        }
        
        return result;
    }
}
