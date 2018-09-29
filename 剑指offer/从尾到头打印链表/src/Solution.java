import java.util.ArrayDeque;
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayDeque<ListNode> s = new ArrayDeque<>();

        while (listNode != null) {
            s.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>(s.size());
        while (!s.isEmpty()) {
            list.add(s.pop().val);
        }

        return list;
    }
}