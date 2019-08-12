class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {

        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode end) {

        if (head != end) {

            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    private ListNode partion(ListNode head, ListNode end) {

        ListNode p1 = head, p2 = head.next;

        while (p2 != end) {

            if (p2.val < head.val) {

                p1 = p1.next;
                swap(p1, p2);
            }
            p2 = p2.next;
        }

        if(p1 != head) {
            swap(p1, head);
        }

        return p1;
    }

    private void swap(ListNode node1, ListNode node2) {
        int t = node1.val;
        node1.val = node2.val;
        node2.val = t;
    }
}