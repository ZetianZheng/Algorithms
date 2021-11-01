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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        // solution1: set记录，发现后跳过，
        // solution2: somehow sort, then same as 82
        
        // two pass:
        ListNode dummy = new ListNode(0, head);
        HashMap<Integer, Integer> map = new HashMap<>(); // val, count
        
        // first pass, record number of nodes with same value.
        while (head != null) {
            map.putIfAbsent(head.val, 0);
            map.put(head.val, map.get(head.val)+1);
            head = head.next;
        }
        
        // second pass, skip duplicate nodes
        head = dummy.next;
        // predeccessor
        ListNode pred = dummy;
        while (head != null) {
            // find duplication
            if (map.get(head.val) > 1) {
                pred.next = head.next;
                head = head.next;
            } else {
                head = head.next;
                pred = pred.next;
            }
        }
        
        return dummy.next;
    }
}