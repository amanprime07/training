package com.training.linkedlist.medium;

import com.training.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

public class DetectLoop {

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
        fifth.next = third;

        System.out.println(bruteForce(head));
        System.out.println(detectLoop(head));
    }

    private static boolean bruteForce(Node head) {
        Map<Node, Boolean> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            } else {
                map.put(temp, true);
            }
            temp = temp.next;
        }
        return false;
    }

    private static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
