class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode r, l, pre, fuyi;
        l = r = head;

        fuyi = new ListNode(-1);
        fuyi.next = head;

        pre = fuyi;
        for (int i = 0; i < n; i++) {
            r = r.next;
        }

        while (r != null) {
            pre = l;
            l = l.next;
            r = r.next;
        }
        pre.next = pre.next.next;
        return fuyi.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        head = new Solution().removeNthFromEnd(head, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}