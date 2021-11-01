class v2 {
    public int minDifference(int[] nums) {
        // 根据之前的方法，我们只用到了数组排序后的前4个值和后四个值。
        // 所以可以使用最大堆最小堆来维护最大的四个值和最小的四个值，之后的逻辑是一样的使用sliding window
        if (nums.length < 5)
            return 0;
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) {
            minpq.add(n);
            maxpq.add(n);
            if (minpq.size() > 4) minpq.poll();// 小顶堆但是排出了所有的其他元素只剩下最大的4个元素
            if (maxpq.size() > 4) maxpq.poll();// 大顶堆但是排出了所有的其他元素只剩下最小的4个元素
        }
        int diff = Integer.MAX_VALUE;
        int[] minA = new int[4];
        int[] maxA = new int[4];
        for (int i = 0, k = 3; i < 4; i++, k--) {
            maxA[i] = minpq.poll(); // [4, 5, 6, 7]
            minA[k] = maxpq.poll(); // [1, 2, 3, 4] 最小的4个值降序排序，再进行reverse操作排成顺序。
        }
        
        for (int i = 0; i < 4; i++) {
            diff = Math.min(diff, maxA[i] - minA[i]);
        }
        
        return diff;
    }
}