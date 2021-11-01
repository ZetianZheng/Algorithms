class v1 {
    public int maxProfit(int[] prices) {
        int i = 0, len = prices.length, maxprofit = 0;
        int valley = prices[0], peak = prices[0];
        while (i < len - 1) {
            // find the next valley
            while (i < len - 1 && prices[i] >= prices[i+1]) 
                i++;
            
            valley = prices[i];
            // find the next peak
            while (i < len - 1 && prices[i] <= prices[i+1] )
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        
        return maxprofit;
    }
}