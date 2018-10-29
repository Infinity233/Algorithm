class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode t = new ListNode(-1);
        ListNode head = t;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            head = head.next;
        }

        while (list1 != null) {
            head.next = new ListNode(list1.val);
            list1 = list1.next;
            head = head.next;
        }

        while (list2 != null) {
            head.next = new ListNode(list2.val);
            list2 = list2.next;
            head = head.next;
        }

        return t.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(3);
        h1.next.next = new ListNode(5);

        ListNode h12 = new ListNode(2);
        h12.next = new ListNode(4);
        h12.next.next = new ListNode(6);

        ListNode merge = new Solution().Merge(h1, null);
        System.out.println();
    }
}