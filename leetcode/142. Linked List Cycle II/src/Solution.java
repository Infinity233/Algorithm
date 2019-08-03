class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode l = head;
        ListNode r = head;
        while (r != null && r.next != null) {
            r = r.next.next;
            l = l.next;
            if (l == r) {
                ListNode res = head;

                while(res != r) {
                    res = res.next;
                    r = r.next;
                }
                return res;
            }
        }
        return null;
    }
}