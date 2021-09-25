class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // merge intervals
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < firstList.length && j < secondList.length) {
            // intervals is the max bound between start points and min bound between end points.
            
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= high) // low <= high 才有交集。
                ans.add(new int[]{lo, high});
            
            // move on who ended first
            if (firstList[i][1] < secondList[j][1])
                i++;
            else 
                j++;
        }
        
        return ans.toArray(new int[ans.size()][]);
        
    }
}