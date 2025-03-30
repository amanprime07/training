package com.training.linkedlist.medium;

import com.training.linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLoop {

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

        System.out.println(bruteForce(head));
        System.out.println(optimized(head));
    }

    private static int optimized(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
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

    private static int findLength(ListNode slow, ListNode fast) {
        int count = 1;
        while (slow != fast) {
            count++;
            slow = slow.next;
        }
        return count;
    }

    private static int bruteForce(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
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
