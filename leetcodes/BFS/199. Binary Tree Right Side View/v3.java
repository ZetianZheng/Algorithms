public class v3 {
    public List<Integer> rightSideView(TreeNode root) {
        // bfs + sentinel 使用null记录sentinel
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        queue.offer(null); // sentinel, 第一层的结束位置
        TreeNode prev, curr = root;
        
        while(!queue.isEmpty()) {
            prev = curr; // backup last node.
            curr = queue.poll();
            
            while (curr != null) { // 还没到当前层的结束位置之前(sentinel)
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
                prev = curr;
                curr = queue.poll();
            }
            
            // 本层结束.
            ans.add(prev.val);
            if (!queue.isEmpty())
               queue.offer(null);
        }
            
        return ans;    
    }
}
