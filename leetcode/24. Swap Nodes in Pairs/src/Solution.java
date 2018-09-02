
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t,tt;
        tt = head.next.next;
        t = head;
        head = head.next;
        head.next = t;
        t.next = tt;

        while (t.next != null) {
            t = swap(t);
        }

        return head;
    }

    static ListNode swap(ListNode now) {
        if (now.next.next == null) {
            return now.next;
        } else {
            ListNode t = now.next;
            now.next = now.next.next;


            t.next = now.next.next;
            now.next.next = t;

            return t;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode list = head;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(3);
        list = list.next;
//        list.next = new ListNode(4);
//        list = list.next;
        head = new Solution().swapPairs(head);
        printList(head);
    }

    static void printList(ListNode head){
        while(head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
