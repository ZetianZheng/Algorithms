class v1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode lastNode= head;
        int n;
        for (n = 1; lastNode.next != null; n++) {
            lastNode= lastNode.next;
        }
        // close the linked list to the ring
        lastNode.next = head;
        
        // find the new tail.
        ListNode new_tail = head;
        for (int i= 0; i < n - k % n - 1; i++) { // 新的尾部：n - k % n - 1， 新的头部：n - k % n。
            new_tail = new_tail.next;
        }
        
        // find the new head.
        ListNode new_head = new_tail.next;
        // break the cycle.
        new_tail.next = null;
        
        return new_head;
    }
}