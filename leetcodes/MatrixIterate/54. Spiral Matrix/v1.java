class v1 {
    int[][] dirs = new int[][]{{0,1}, {1, 0}, {0, -1}, {-1, 0}}; // 右，下，左，上。
    int VISITED = 101;
    public List<Integer> spiralOrder(int[][] matrix) {
        // 00, 01, 02, 12, 22, 21, 20, 
        int n = matrix.length;
        int m = matrix[0].length;
        
        List<Integer> ret = new ArrayList<>();
        
        // 遍历这种二维矩阵有没有什么技巧？注意方向的变化。// rotate image.
        // 方向：右，下，左， 上。
        // 什么时候方向会变？
        // 1. when comes to the boundary,
        // 2. when comes to the visted elements.
        // 什么时候停止搜索？
        // 方向不再变化

        int d = 0; // directions start from to right.
        int changeDirs = 0;
        int row = 0, col = 0;
        ret.add(matrix[row][col]);
        matrix[row][col] = VISITED;
        
        
        while (changeDirs < 2) {
            while ( row + dirs[d][0] >= 0 && 
                    row + dirs[d][0] < n &&
                    col + dirs[d][1] >= 0 &&
                    col + dirs[d][1] < m &&
                    matrix[row + dirs[d][0]][col + dirs[d][1]] != VISITED) {
                changeDirs = 0; // 方向还有变化，置为0.
                row = row + dirs[d][0];
                col = col + dirs[d][1];
                ret.add(matrix[row][col]);
                matrix[row][col] = VISITED;
            }   
            changeDirs++; // 如果没有进入上面那个循环，说明已经遍历结束了。 changeDirs == 2.
            // over the boundary
            d = (d+1) % 4;
        }
        return ret;
    }
}