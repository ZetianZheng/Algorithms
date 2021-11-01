class Solution {
    // 不需要每一个i于j都相减，进行优化：只需要记录最小值， 后面遇到比他大的值更新max profit， 小的更新最小值
    public int maxProfit(int[] prices) {
        int max_pro = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i]; // find current bottom, record
            else if (max_pro < prices[i] - min) 
                max_pro = prices[i] - min;
            
        }
        
        return max_pro;
    }
}