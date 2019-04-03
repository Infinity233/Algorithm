import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Node head, tail;
    private Map<Integer, Node> map;
    Integer size;

    public LRUCache(int capacity) {
        map = new HashMap<>((int) (capacity * 1.5));
        size = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            moveToHead(node);
            node.value = value;
            return;
        }

        if (map.size() >= size) {
            removeTail();
        }

        node = new Node(key, value);
        moveToHead(node);
        map.put(key, node);

    }

    private void removeTail() {
        if (tail == null) {
            return;
        }
        map.remove(tail.key);
        if (tail.pre == null) {
            head = tail = null;
            return;
        }

        tail.pre.next = null;
        tail = tail.pre;
    }

    private void moveToHead(Node node) {

        if (head == null) {
            head = tail = node;
            return;
        } else if(node == head) {
            return;
        }

        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }

        if(node == tail && head != tail) {
            tail = node.pre;
        }
        node.pre = null;
        node.next = head;
        head.pre = node;
        head = node;
    }

    static class Node {
        int key, value;
        Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);
//["LRUCache","put","put","get","get","put","get","get","get"]
//[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
        // [null,null,null,2,1,null,1,-1,3]
        cache.put(2,1);
        cache.put(3,2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */