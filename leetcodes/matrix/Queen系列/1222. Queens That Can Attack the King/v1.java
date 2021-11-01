class v1 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // king从横竖以及斜边出去后遇到的第一个queen是答案。
        // set 记录所有的queen，king出发去四边找到第一个：
        // 不能用set， 因为int[] 不是基本类型而是不同的地址。
        List<List<Integer>> ret = new ArrayList<>();
        
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        
        boolean[][] seen = new boolean[8][8];
        for (int[] qs : queens) {
            seen[qs[0]][qs[1]] = true;
        }
        
        int BOARD = 8;
        int kx = king[0];
        int ky = king[1];
        
        for (int i = 0; i < dirs.length; i++) {
            int x = kx;
            int y = ky;
            while (x + dirs[i][0] >= 0 && y + dirs[i][1] >= 0 && x + dirs[i][0] < BOARD && y + dirs[i][1] < BOARD) {
                x += dirs[i][0];
                y += dirs[i][1];
                
                if (seen[x][y]) {
                    ret.add(Arrays.asList(x, y));
                    break;
                }
            }
        }
        
        return ret;
    }
}