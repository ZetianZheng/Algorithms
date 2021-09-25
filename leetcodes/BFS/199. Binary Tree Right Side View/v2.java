public class v2 {
    private List<Integer> ans = new ArrayList<>();
    
    public void helper(TreeNode root, int level) {
        if (level == ans.size())  // 控制最先进来的递归叶子节点，是从左边能看到的节点。
            ans.add(root.val);
        
        if (root.right != null) // 从右边开始递归。所以如果右边不为空的话肯定最先进去ans，这一层就只能看到这个节点了。
            helper(root.right, level + 1);
        if (root.left != null)
            helper(root.left, level + 1);
        
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        // dfs,每次从最左边的孩子遍历，用ans数组长度控制得到最左边的孩子。
        if (root == null)
            return ans;
        helper(root, 0);
        return ans;
    }
}
