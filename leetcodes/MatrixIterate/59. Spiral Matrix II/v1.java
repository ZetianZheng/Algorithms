class v1 {
    public int[][] generateMatrix(int n) {
        int count = n * n;
        // 4 boundaries 
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        
        int i = 1; 
        int[][] matrix = new int[n][n];
        while (i <= count) {
            // left to right;
            for (int j = left; j <= right; j++) {
                matrix[up][j] = i++;
            }
            
            // downwards
            for (int j = up + 1; j <= down; j++) {
                matrix[j][right] = i++;
            }
            
            // right to left
            for (int j = right - 1; j >= left; j--) {
                matrix[down][j] = i++;
            }
            
            // upwards
            for (int j = down - 1; j > up; j--) {
                matrix[j][left] = i++;
            }
            
            up++;
            down--;
            left++;
            right--;
        }
        
        return matrix;
    }
}