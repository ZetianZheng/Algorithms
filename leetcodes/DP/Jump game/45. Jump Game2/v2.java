class v2 {
    public int jump(int[] nums) {
        // greed 算法 O(n), O(1).
        int rightmost = 0;
        int step = 0;
        int end = 0;// end 确定step步之内能走到的最远边界。
        for (int i = 0; i < nums.length - 1; i++){
            rightmost = Math.max(rightmost, i + nums[i]); // 当前步数能到达的最远边界
            if (end == i) { // 当当前步已经走到上一个边界的时候，需要把边界更新。步数加一。
                end = rightmost;
                step++;
            }
        }
        return step;
    }
}