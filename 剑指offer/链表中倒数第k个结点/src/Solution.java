import java.util.Scanner;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode r = head;
        while (k-- != 0) {
            if(r == null) {
                return null;
            }
            r = r.next;
        }

        while (r != null) {
            r = r.next;
            head = head.next;
        }

        return head;
    }
}