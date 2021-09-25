public class BSTIterator1 {
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
    // dfs遍历放入array，判断长度来确定是否还有next，space：O(n), next() time :O(1)
    List<Integer> list;
    int index;
    public BSTIterator1(TreeNode root) {
        this.list = new ArrayList<>();
        this.index = 0;
        
        helper(root);
    }
    
    private void helper(TreeNode root) {
        if (root == null)
            return;
        // inorder 
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
    
    public int next() {
        return list.get(this.index++);
    }
    
    public boolean hasNext() {
        return index < list.size();
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
