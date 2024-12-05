package com.training.linkedlist.medium;

import com.training.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLoop {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = head;

        System.out.println(bruteForce(head));
        System.out.println(optimized(head));
    }

    private static int optimized(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // loop detected
                return findLength(slow.next, fast);
            }
        }
        return 0;
    }

    private static int findLength(Node slow, Node fast) {
        int count = 1;
        while (slow != fast) {
            count++;
            slow = slow.next;
        }
        return count;
    }

    private static int bruteForce(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (map.containsKey(temp)) {
                return count - map.get(temp);
            } else {
                map.put(temp, count);
            }
            temp = temp.next;
        }
        return 0;
    }
}
