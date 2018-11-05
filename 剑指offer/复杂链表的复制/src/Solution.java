class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode it = pHead, t;
        while (it != null) {
            t = new RandomListNode(it.label);
            t.next = it.next;
            it.next = t;
            it = it.next.next;
        }

        it = pHead;

        while (it != null) {
            it.next.random = it.random.next;
            it = it.next.next;
        }

        it = pHead.next;

        while (true) {
            if(it.next!= null) {
                it.next = it.next.next;
            } else {
                break;
            }
            it = it.next;
        }
        return pHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        RandomListNode node = new RandomListNode(1);
        node.next = node;
        RandomListNode clone = s.Clone(node);
        System.out.println();
    }
}