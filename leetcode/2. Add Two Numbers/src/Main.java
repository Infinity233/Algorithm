import java.util.Scanner;

public class Main {

    Scanner cin = new Scanner(System.in);

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        int jin = 0, mod = 10, t = 0;
        ListNode pre = null;
        while (l1 != null && l2 != null) {

            t = l1.val + l2.val + jin;
            jin = 0;
            if (t > 9) {
                jin = 1;
                t %= mod;
            }
            l3.val = t;

            l3.next = new ListNode(-1);
            pre = l3;
            l3 = l3.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {

            while (l1 != null) {
                l3.val = l1.val + jin;
                jin = 0;
                if (l3.val > 9) {
                    jin = 1;
                    l3.val %= mod;
                }
                l3.next = new ListNode(-1);
                pre = l3;
                l3 = l3.next;
                l1 = l1.next;
            }

        } else if (l2 != null) {
            while (l2 != null) {
                l3.val = l2.val + jin;
                jin = 0;
                if (l3.val > 9) {
                    jin = 1;
                    l3.val %= mod;
                }

                l3.next = new ListNode(-1);
                pre = l3;
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        if (jin != 0) {
            l3.val = 1;

            l3.next = new ListNode(-1);
            pre = l3;
            l3 = l3.next;
        }

        pre.next = null;
        return head;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(3);
//        l2.next = new ListNode(2);
//        l2.next.next = new ListNode(1);
//        l2.next.next.next = new ListNode(3);

        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        Main main = new Main();
        main.printList(main.addTwoNumbers(l1, l2));
    }

    public void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
