class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l = head;
        ListNode r = head;

        while (r != null && r.next != null) {
            r = r.next.next;
            l = l.next;
            if(l == r) {
                return true;
            }
        }
        return false;
    }
}