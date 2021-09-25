/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class v1 {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node ret = new Node(insertVal);
            ret.next = ret;
            return ret;
        }
        
        Node prev = head;
        Node cur = head.next;
        boolean toInsert = false;
        do {
            if (insertVal >= prev.val && insertVal <= cur.val) { // case1：插入值在最小和最大之间
               toInsert = true;
            } else if (prev.val > cur.val) { // case2: 在环的尾端，这个值比尾端的值更大或者比开头的值更小都可以插入。
                if (insertVal >= prev.val || insertVal <= cur.val)
                    toInsert = true;
            }
            
            if (toInsert) {
                prev.next = new Node(insertVal, cur);
                return head;
            }
                
            prev = cur;
            cur = cur.next;
        } while(prev != head); // 循环终止条件，prev回到head的地方。
        // 如果上三种情况都不符合，说明插入值的地方可能都是相同值。直接插入
        prev.next = new Node(insertVal, cur);
        return head;
    }
}