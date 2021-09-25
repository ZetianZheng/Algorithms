public class v2 {
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        // 从右往左遍历，如果这一行发现了0，那么说明后面都没有1了，所以可以直接去下一行。
        // 如果发现了 1，说明后面可能还有1，那么就继续搜索。
        // O(m + n)
        // O(1)
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        
        int i = 0; 
        int j = col - 1;
        int ret = col;
        while (i < row) { // 遍历每一列
            while (j >= 0) { // 遍历每一行
                if (binaryMatrix.get(i, j) == 1) {
                    ret = Math.min(ret, j);
                    j--;
                }
                else 
                    break;
            }
            i++;
        }
        
        return ret == col ? -1:ret;
    }
}
