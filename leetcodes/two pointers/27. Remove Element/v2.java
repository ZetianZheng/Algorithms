class v2 {
    public int removeElement(int[] nums, int val) {
        // 因为顺序可以改变，所以可以直接把值丢到最后并将length - 1
        int n = nums.length - 1; 
        int j = 0;
        while (j < n) {
            if (nums[j] == val) {
                nums[j] = nums[n--];
            } else { // 有可能换回来的还是val，所以再判断一次，不是再前进。
                j++;
            }
        }
        
        return n + 1;
    }
}