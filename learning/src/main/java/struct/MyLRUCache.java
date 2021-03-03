package struct;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cwp
 */
public class MyLRUCache {

    int size, capacity;
    Node head, tail;
    Map<Integer, Node> cache = new HashMap<>();

    class Node {
        int val;
        int key;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

    public MyLRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, Integer value) {
        Node node = cache.get(key);
        if (null == node) {
            if (size >= capacity) {
                Node prev = tail.prev;
                removeNode(prev);
                cache.remove(prev.key);
            }
            Node node1 = new Node(key, value);
            addToHead(node1);
            cache.put(key, node1);
        } else {
            node.val = value;
            removeNode(node);
            addToHead(node);
            cache.put(key, node);
        }

    }

    public int get(int key) {
        Node node = cache.get(key);
        if (null == node) {
            return -1;
        }
        int val = node.val;
        removeNode(node);
        addToHead(node);
        return val;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    // h -> node1 -> node2 -> node3-> t
    private void addToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
        size++;
    }

    public static void main(String[] args) {

    }
}
