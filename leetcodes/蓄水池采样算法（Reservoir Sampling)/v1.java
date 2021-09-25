class Solution {
    // brute force, 用O(n)的时间复杂度，对整个数组进行遍历，这样如果有数字和target相等就保存下其索引位置。再从这些索引位置中等概率返回任意一个即可。
    private int[] nums;
    private Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        List<Integer> indices = new ArrayList<>();
        int n = this.nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                indices.add(i);
            }
        }
        
        int l = indices.size();
        
        int randomIndex = indices.get(rand.nextInt(l)); // get Random index.
        
        return randomIndex;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */