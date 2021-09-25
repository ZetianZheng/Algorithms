public class v1 {
    /**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        // 每行做一次二分法，logm * n < 1000
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        
        int ret = col + 1;
        for (int i = 0; i < row; i++) {
            ret = Math.min(ret, binarySearch(binaryMatrix, i, 0, col - 1));
        }
        
        if (ret > col) // 如果没有1，那么则输出-1.
            return -1;
        
        return ret;
    }
    
    public int binarySearch(BinaryMatrix bm, int row, int l, int r) {
        while (l < r) {
            int mid = (l+r) / 2;
            if (bm.get(row, mid) < 1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 如果不为1，说明这一行没有0， 输出最大值。
        return bm.get(row, r) == 1 ? r : Integer.MAX_VALUE;
    }
}
