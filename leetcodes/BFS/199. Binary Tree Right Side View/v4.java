public class v4 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>(); // 使用arrayDeque，双端队列，方便clone，clear操作。
        nextLevel.offer(root);
        ArrayDeque<TreeNode> currLevel = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        
        TreeNode curr = null; // 这里把node摘出来，方便在每层结束的时候记录进答案。
        while (!nextLevel.isEmpty()) {
            currLevel = nextLevel.clone(); // 把nextlevel导到当前队列， 再把nextlevel清空。
            nextLevel.clear();
            
            while (!currLevel.isEmpty()) {
                curr = currLevel.poll();
                if (curr.left != null)
                    nextLevel.offer(curr.left);
                if (curr.right != null)
                    nextLevel.offer(curr.right);
            }
            
            if (currLevel.isEmpty())
                ans.add(curr.val);
        }
        
        return ans;
    }
}
