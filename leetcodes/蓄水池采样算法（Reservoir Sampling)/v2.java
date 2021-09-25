class Solution {
    // hashmap 优化pick时间复杂度：
    private int[] nums;
    private HashMap<Integer, List<Integer>> indices;
    private Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        this.indices = new HashMap<>();
        this.rand = new Random();
        
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (!this.indices.containsKey(nums[i])) {
                this.indices.put(nums[i], new ArrayList<>());
            }
            
            this.indices.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int l = indices.get(target).size();
        return indices.get(target).get(rand.nextInt(l));
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */