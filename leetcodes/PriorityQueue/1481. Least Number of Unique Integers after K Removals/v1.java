class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 首先算频率，算完频率使用自定义优先队列来排序，每次去除最顶端的s个元素。直到k小于等于0.
        HashMap<Integer, Integer> currencyMap = new HashMap<>();
        
        for (int num : arr) // O(n)
            currencyMap.put(num, currencyMap.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->currencyMap.get(a) - currencyMap.get(b));
        
        pq.addAll(currencyMap.keySet()); // O(mlogm)
        
        while (k > 0) { // O(M)
            k = k - currencyMap.get(pq.poll()); // 每次k减去当前pq最顶的元素
        }
        
        return k == 0 ? pq.size() : pq.size() + 1;
    }
}