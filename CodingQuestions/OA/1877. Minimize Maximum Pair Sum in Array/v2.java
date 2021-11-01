class v2 {
    public int minPairSum(int[] nums) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); 
        int len = nums.length;
        for (int i : nums) {
            min.add(i);
            max.add(i);
        }
        
        int minMax = Integer.MIN_VALUE;
        while (!min.isEmpty()) {
            minMax = Math.max(minMax, min.poll() + max.poll());
        }
        
        return minMax;
    }
}