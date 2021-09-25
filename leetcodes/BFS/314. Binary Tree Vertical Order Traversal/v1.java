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
    public Map<Integer, List<Integer>> map = new TreeMap<>(); // flag : treeNode, 使用treeMap 保留key的顺序。
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        // dfs(root, 0); 因为顺序是从上到下，所以不用dfs，用bfs。
        bfsFromRoot(root);
        
        for (Integer key : map.keySet()) {
            ret.add(map.get(key));
        }
        
        return ret;
    }
    
    public void bfsFromRoot(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> qCol = new LinkedList<>();
        queue.offer(root);
        qCol.offer(0); // root column equals to 0.
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curCol = qCol.poll();
            if (!map.containsKey(curCol))
                map.put(curCol, new ArrayList<Integer>());
            map.get(curCol).add(cur.val);
            
            if (cur.left != null) {
                queue.offer(cur.left);
                qCol.offer(curCol - 1);
            }
            
            if (cur.right != null) {
                queue.offer(cur.right);
                qCol.offer(curCol + 1);
            }    
        }
        
    }
}
