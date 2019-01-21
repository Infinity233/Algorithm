import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        LinkedList<ArrayList<Integer>> t = new LinkedList<>();
        Node node = new Node(sum / 2, sum / 2 + 1);
        while (node.getHead() != 0) {

            if (node.getSum() == sum) {

                t.addFirst(node.toArrayList());
                node.tailDecrement();
                node.headDecrement();
            } else if (node.getSum() > sum) {
                node.tailDecrement();
                node.headDecrement();
            } else {
                node.headDecrement();
            }
        }

        return new ArrayList<>(t);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> list = s.FindContinuousSequence(100);
        System.out.println(list.toString());
    }
}

class Node {

    private int head, tail, sum;

    public Node(int head, int tail) {
        this.head = head;
        this.tail = tail;
        calSum();
    }


    private void calSum() {

        this.sum = (this.head + this.tail) * (this.tail - this.head + 1) / 2;
    }

    public ArrayList<Integer> toArrayList() {
        ArrayList<Integer> list = new ArrayList<>(this.tail - this.head + 1);

        for (int i = this.head; i <= this.tail; i++) {
            list.add(i);
        }

        return list;
    }

    public void headDecrement() {
        --this.head;
        calSum();
    }

    public void tailDecrement() {
        --this.tail;
        calSum();
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
        calSum();
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
        calSum();
    }

    public int getSum() {
        return sum;
    }
}