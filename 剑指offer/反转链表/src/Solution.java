class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode go = head;

        head = null;
        ListNode back;
        while (go != null) {
            back = go;
            go = go.next;

            back.next = head;
            head = back;
        }

        return head;
    }
}