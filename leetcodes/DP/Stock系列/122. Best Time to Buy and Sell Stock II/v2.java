class v2 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int profit = prices[i] - prices[i - 1];
                max += profit;
            }
        }
        
        return max;
    }
}