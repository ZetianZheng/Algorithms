public class v1 {
    public List<Integer> rightSideView(TreeNode root) {
        // BFS, 每次记录queue的最后一个值
        List<Integer> ans = new ArrayList<>();
        
        if (root == null)
            return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (i == size - 1)
                    ans.add(currentNode.val);
                
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }    
            }
        }
        
        return ans;
    }
}
