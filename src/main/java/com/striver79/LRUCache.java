package com.striver79;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, DNode> map;
    DNode head;
    DNode tail;
    DNode temp = new DNode(-1, -10);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = temp;
        tail = temp;
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 3);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DNode n = map.get(key);
            remove(n);
            insert(n);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DNode n = map.get(key);
            remove(n);
        }

        if (capacity == map.size()) {
            remove(tail.prev);
        }
        DNode n = new DNode(key, value);
        insert(n);
    }

    private void insert(DNode n) {
        map.put(n.key, n);
        n.next = head.next;
        n.next.prev = n;
        head.next = n;
        n.prev = head;

    }

    private void remove(DNode n) {
        map.remove(n.key);
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }

    private static class DNode {
        int key;
        int value;
        DNode next;
        DNode prev;

        public DNode(int k, int val) {
            this.value = val;
            this.key = k;
        }

        @Override
        public String toString() {
            return "DNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
