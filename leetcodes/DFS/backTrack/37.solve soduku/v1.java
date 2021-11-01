class v1 {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }
    
    boolean backTrack(char[][] board, int i, int j) {
        // col 达到9，说明要换行
        if (j == 9) {
            return backTrack(board, i + 1, 0);
        }
        // row 达到9，说明所有的条件都符合，结束完成数独
        if (i == 9) {
            return true;
        }
        // 忽略有数字的部分
        if(board[i][j] != '.') {
            return backTrack(board, i, j + 1);
        }
        // 尝试在里面添加数字
        for (int d = 1; d <= 9; d++) {
            if (!isValid(board, i, j, d)) {
                continue;
            }
            // back track 尝试
            board[i][j] = (char)('0' + d);
            if (backTrack(board, i, j + 1)){
                return true;
            }
            board[i][j] = '.';
        }
        
        return false;
    }
    
    public boolean isValid(char[][] board, int row, int col, int num) {
        char n = (char)('0' + num);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n) {
                return false;
            }
            if (board[i][col] == n) {
                return false;
            }
            int rowInd = 3*(row / 3) + i / 3;
            int colInd = 3 * (col / 3) + i % 3;
            if (board[rowInd][colInd] == n) {
                return false;
            }
        }
        return true;
    }
}