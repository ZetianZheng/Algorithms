class v2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 方法2： 根据边界来控制什么时候转换方向，每次转换方向之后更新边界。
        // 4 boundaries:
        int n = matrix.length;
        int m = matrix[0].length;
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;
        
        List<Integer> ret = new ArrayList<>();
        

        while (ret.size() < n * m) {
            // left to right.
            for (int j = left; j <= right; j++) {
                ret.add(matrix[up][j]);
            }
            
            // downwards
            for (int j = up + 1; j <= down; j++) {
                ret.add(matrix[j][right]);
            }
            
            // right to left
            if (up < down) {
                for (int j = right - 1; j >= left; j--) {
                    ret.add(matrix[down][j]);
                }    
            }
            
            
            // upwards
            if (left < right) {
                for (int j = down - 1; j > up; j--) {
                    ret.add(matrix[j][left]);
                }
            }
            
            // update boundaries
            up++;
            down--;
            left++;
            right--;
        }
        
        return ret;
    }
}