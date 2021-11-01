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
    public ListNode partition(ListNode head, int x) {
        // 使用two pointer 而不同插入法会简单一点：
        // before -> the node less than x
        // after -> the node larger than or equal with x
        ListNode before_dummy = new ListNode(0, null);
        ListNode before = before_dummy;
        ListNode after_dummy = new ListNode(0, null);
        ListNode after = after_dummy;
        
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        // joint these two lists
        before.next = after_dummy.next;
        after.next = null;
        return before_dummy.next;
    }
}