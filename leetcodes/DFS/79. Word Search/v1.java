class v1 {
    int[] dirs = {0, 1, 0, -1, 0};
    char[][] board;
    char[] words;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.board = board;
        this.words = word.toCharArray();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs (i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs (int i, int j, int ind) {
        if (ind == words.length - 1 && board[i][j] == words[ind]) {
            return true;
        }
        
        if (words[ind] != board[i][j]) {
            return false;
        }
        
        board[i][j] = '*'; // visited;
        for (int d = 0; d < 4; d++) {
            int nx = i + dirs[d];
            int ny = j + dirs[d + 1];
            
            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length) {
                if (dfs (nx, ny, ind + 1)) {
                    return true;
                }
            }
        }
        
        board[i][j] = words[ind];
        return false;
    }
}