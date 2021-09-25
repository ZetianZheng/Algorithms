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
class BSTIterator2 {

    Stack<TreeNode> stack;
    public BSTIterator2(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        // recursion to the left most leaf node.
        this.leftMostInorder(root);
    }
    
    public void leftMostInorder(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        if (!hasNext())
            throw new IllegalArgumentException();
        
        // stack push 
        TreeNode topMostNode = this.stack.pop();
        if (topMostNode.right != null) {
            leftMostInorder(topMostNode.right);
        }
        
        return topMostNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */