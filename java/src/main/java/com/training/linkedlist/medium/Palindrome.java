package com.training.linkedlist.medium;

import com.training.linkedlist.ListNode;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        int[] arr = {-4, -8, -10, -9, 4, 0, 4, -9, -10, -8, -4};
        ListNode head = ListNode.createList(arr);
        System.out.println(bruteForce(head));
        System.out.println(optimize(head));
//        System.out.println(recursive(head, head.next));
        head.print();
    }

    private static boolean optimize(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        head.print();
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        1,2,3,3,2,1-> head->1,2,3, reverse = 1,2,3
        ListNode reverse = reverse(slow);
        ListNode temp = head;
        ListNode temp2 = reverse;
        while (reverse != null) {
            if (temp.v != reverse.v) {
                reverse(temp2);
                return false;
            }
            temp = temp.next;
            reverse = reverse.next;
        }
        reverse(temp2);
        return true;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;

            curr = temp;
        }
        return prev;
    }

    private static boolean bruteForce(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.v);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.v != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    private static boolean recursive(ListNode head, ListNode next) {
        if (next == null) {
            return true;
        }
        recursive(head, head.next);

        ListNode temp = head;
        while (temp != null) {
            if (temp.v != next.v) {
                return false;
            }
            temp = temp.next;
        }
        return true;

    }
}
