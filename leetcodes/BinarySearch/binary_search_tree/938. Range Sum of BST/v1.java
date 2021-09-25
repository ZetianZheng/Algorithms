/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 二叉搜索树复习
        // DFS binary search for element between low bound and high bound.
        // O(N)
        ans = 0;
        
        dfs(root, low, high); 

        return ans;
    }
    
    public void dfs(TreeNode node, int low, int high) {
        if (node == null)
            return;
        
        if (node.val >= low && node.val <= high) 
            ans += node.val;
        if (low < node.val) // 当前值还比左边界大，说明它的左子树还可以继续遍历
            dfs(node.left, low, high);
        if (node.val < high) // 当前值还比右边界小，说明它的右子树还可以继续遍历
            dfs(node.right, low, high);
    }
}