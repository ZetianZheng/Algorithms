/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class v1 {
    public ListNode deleteDuplicates(ListNode head) {
        // solution 1 使用set记录，没有就复制加入新的节点后面。
        // using sentinel, 
        ListNode sentinel = new ListNode(0, head);
        // predecessor
        ListNode pred = sentinel;
        
        while(head != null) {
            // if it is beginning of duplicate.
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pred.next = head.next; // skip all duplicate nodes.
            } else {
                pred = pred.next; 
            }
            
            head = head.next;
        }
        
        return sentinel.next;
    }
}