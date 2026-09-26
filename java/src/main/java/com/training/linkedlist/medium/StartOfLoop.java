package com.training.linkedlist.medium;

import com.training.linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

public class StartOfLoop {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = head;
        long startTime = System.nanoTime();
        ListNode start = bruteForce(head);
        long timeTaken = System.nanoTime() - startTime;
        System.out.println("bruteForce timeTaken " + timeTaken / 1000);
        System.out.println(start.v);
        startTime = System.nanoTime();
        start = optimized(head);
        timeTaken = System.nanoTime() - startTime;
        System.out.println("bruteForce timeTaken " + timeTaken / 1000);
        System.out.println(start.v);
    }

    private static ListNode optimized(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
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

    private static ListNode bruteForce(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;

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
