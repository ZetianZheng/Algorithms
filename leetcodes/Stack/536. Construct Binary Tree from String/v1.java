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
    public TreeNode str2tree(String s) {
        // 使用stack后进先出的特性存储这些点。
        // 每次出现右括号则肯定遍历完一个子树。那么进行一个stack的pop操作。
        // 最顶点root的括号肯定是在整个字符串的最后。
        // 每次找到数字则将它和当前stack的最顶端元素进行链接。左子树有东西了就放在右子树
        // 因为这个输入总是合法的，所以不需要担心三个子节点的情况。
        
        Stack<TreeNode> stack = new Stack<>();

        for (int i = 0, j = i; i < s.length(); i++, j = i) {
            char c = s.charAt(i);
            if(c == ')') { // 每次遇到有括号说明这个子树已经看完了，所以排出stack最顶元素。
                stack.pop();
            } else if (Character.isDigit(c) || c == '-'){ // 看到数字或者负号
                // 找全所有的数字并转换
                while(i+1 < s.length() && Character.isDigit(s.charAt(i + 1))) 
                    i++;
                int num = Integer.parseInt(s.substring(j, i + 1));
                
                // 建立树的链接
                TreeNode cur = new TreeNode(num);
                
                if (stack.size() > 0) {
                    TreeNode parent = stack.peek(); // 栈顶元素是父亲节点
                    if (parent.left != null) // 父亲节点左子树为空就放入，不为空就放右子树
                        parent.right = cur;
                    else 
                        parent.left = cur;
                }
                stack.push(cur); // 当前节点push入栈
            }
        }
        
        return stack.isEmpty() ? null : stack.peek();
    }
}