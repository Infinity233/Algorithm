class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(-1);
        ListNode pre = head;
        for (int i = 0; i < lists.length; i++) {

            ListNode t = head.next;
            pre = head;
            ListNode now = lists[i];
            while (now != null) {

                if (t == null) {
                    pre.next = new ListNode(now.val);
                    t = pre.next;
                    pre = t;
                } else if (t.val >= now.val) {
                    ListNode daicha = new ListNode(now.val);
                    daicha.next = pre.next;
                    pre.next = daicha;
                    pre = daicha;
                } else {
                    pre = t;
                    t = t.next;
                    continue;
                }

                now = now.next;
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[]{l1, l2, l3};

        Solution s = new Solution();
        ListNode res = s.mergeKLists(list);
        System.out.println();
    }
}