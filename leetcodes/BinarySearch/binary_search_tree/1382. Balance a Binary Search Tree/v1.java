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
class v1 {
    
    public List<Integer> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        // 二叉树的平衡改建
        // worst solution: get all the values and create a new tree
        // binary tree rebuild -> iterate binary tree + create tree
        if (root == null)
            return root;
        dfs(root);
        // System.out.println(nodes);

        TreeNode node = balancedTree(0, nodes.size() - 1);
        return node;
    }
    // inorder iterate all nodes in the root.
    public void dfs(TreeNode root) {
        if (root == null)
            return;
        
        dfs(root.left);
        nodes.add(root.val);
        dfs(root.right);
    }
    
    // 构造二叉平衡树，使用二分法递归版，每次找到剩下数组的中点，从而满足左边的节点比中点小，右边的所有节点比中点大。
    public TreeNode balancedTree(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = balancedTree(start, mid - 1);
        root.right = balancedTree(mid + 1, end);
        
        return root;
    }
}