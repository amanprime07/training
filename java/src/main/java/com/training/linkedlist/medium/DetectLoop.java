package com.training.linkedlist.medium;

import com.training.linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

public class DetectLoop {

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
        fifth.next = third;

        System.out.println(bruteForce(head));
        System.out.println(detectLoop(head));
    }

    private static boolean bruteForce(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();
        ListNode temp = head;
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

    private static boolean detectLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

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
