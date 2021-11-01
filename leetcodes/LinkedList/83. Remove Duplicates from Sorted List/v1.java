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
        if (head == null || head.next == null) {
            return head;
        }
        // using sentinel, 
        ListNode sentinel = new ListNode(0, head);
        // predecessor
        ListNode pred = sentinel;
        
        while(head.next != null) {
            if (head.val == head.next.val) {
                pred = head;
                // 一直找到下一个指针和当前指针的val不同。
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pred.next = head.next; // 跳过所有中间重复的node
            } else {
                pred = pred.next; // 当前指针和下一个指针不同，移动pred。
                head = head.next; // 移动head指针。
            }
        }
        
        return sentinel.next;
    }
}