class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fake = new ListNode(-1), pre = fake;
        fake.next = head;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = pre.next;
            pre.next = t;
        }

        return fake.next;
    }

    public static void main(String[] args) {
        Solution in = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        in.reverseBetween(node, 2, 4);
    }
}