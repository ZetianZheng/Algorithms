/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first = null;
    Node last = null; // 中序遍历，last是最大值，first是最小。
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        List<Node> list = new ArrayList<>();
        // 使用dfs, 把node放入list中，然后构建双向链表
        dfs(root, list);
        // 链接首尾 形成环。
        Node head = list.get(0);
        Node tail = list.get(list.size() - 1);
        head.left = tail; 
        tail.right = head;
        
        return head;
    }
    
    public void dfs(Node root, List<Node> list) {
        if (root == null) {
            return;
        }
        // Inorder DFS
        dfs(root.left, list);
        list.add(root);
        // link the current node and previous one.
        if (list.size() >= 2) {
            int n = list.size();
            Node a = list.get(n - 2);
            Node b = list.get(n - 1);
            a.right = b;
            b.left = a;
        }
        dfs(root.right, list);
    }
}
