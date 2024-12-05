package com.training.linkedlist.medium;

import com.training.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

public class StartOfLoop {

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
        long startTime = System.nanoTime();
        Node start = bruteForce(head);
        long timeTaken = System.nanoTime() - startTime;
        System.out.println("bruteForce timeTaken " + timeTaken / 1000);
        System.out.println(start.v);
        startTime = System.nanoTime();
        start = optimized(head);
        timeTaken = System.nanoTime() - startTime;
        System.out.println("bruteForce timeTaken " + timeTaken / 1000);
        System.out.println(start.v);
    }

    private static Node optimized(Node head) {
        Node slow = head;
        Node fast = head;
        Node temp = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                temp = slow;
                break;
            }
        }
        if (temp != null) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    private static Node bruteForce(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            } else {
                map.put(temp, 1);
            }
            temp = temp.next;
        }
        return null;
    }
}
