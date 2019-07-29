class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode p, q;
        pre.next = head;
        q = head.next;
        head.next = null;

        while (q != null) {

            p = q;
            q = q.next;
            p.next = pre.next;
            pre.next = p;
        }

        return pre.next;
    }
}