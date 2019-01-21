import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        return sol2(pHead1, pHead2);
//        Set<ListNode> set = new HashSet<>(10000);
//
//        while (pHead1 != null && pHead2 != null) {
//
//            if (set.contains(pHead1)) {
//                return pHead1;
//            } else {
//                set.add(pHead1);
//            }
//
//            if (set.contains(pHead2)) {
//                return pHead2;
//            } else {
//                set.add(pHead2);
//            }
//
//            pHead1 = pHead1.next;
//            pHead2 = pHead2.next;
//        }
//
//        while (pHead1 != null) {
//            if (set.contains(pHead1)) {
//                return pHead1;
//            } else {
//                set.add(pHead1);
//            }
//            pHead1 = pHead1.next;
//        }
//        while (pHead2 != null) {
//            if (set.contains(pHead2)) {
//                return pHead2;
//            } else {
//                set.add(pHead2);
//            }
//            pHead2 = pHead2.next;
//        }
//
//        return null;
    }

    public ListNode sol2(ListNode pHead1, ListNode pHead2) {

        int len1 = 0;
        int len2 = 0;

        for (ListNode t = pHead1; t != null; t = t.next) {
            len1++;
        }
        for (ListNode t = pHead2; t != null; t = t.next) {
            len2++;
        }

        if (len2 > len1) {
            ListNode t = pHead1;
            pHead1 = pHead2;
            pHead2 = t;

            int num = len1;
            len1 = len2;
            len2 = num;
        }

        int cha = len1 - len2;
        for (; cha != 0; --cha, pHead1 = pHead1.next) {
        }

        for (; pHead1 != pHead2; pHead2 = pHead2.next, pHead1 = pHead1.next) {

        }

        return pHead1;
    }
}