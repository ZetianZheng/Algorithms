class Solution {
    public int minDistance(String word1, String word2) {
        // 经典二维dp: 大问题转换为小问题：
    // dp[i][j] = 1 ~ i 的字符串到 1~j的字符串的编辑距离
        // word1[i] == word2[j] : 
        // dp[i][j] = dp[i - 1][j - 1]
        // 假设word1[i] != word2[j] 
        // 三个转换步骤word1 -> word2
        // 1. insert: dp[i][j - 1] + 1
        // 2. remove: dp[i - 1][j] + 1
        // 3. replace: dp[i - 1][j - 1] + 1
        
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1]; // 多出来的一列、行为了初始化，说明一个是空的，怎么转换过去（全加、全删）
        
        // init
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;   
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        
        // 状态转移：
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                   dp[i][j] = dp[i - 1][j - 1]; 
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        
        return dp[n][m];
    }
}