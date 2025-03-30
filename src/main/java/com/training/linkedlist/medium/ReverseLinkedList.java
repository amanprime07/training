package com.training.linkedlist.medium;

import com.training.linkedlist.ListNode;

import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = ListNode.createList(arr);
        head.print();
        head = reverse(head);
        head.print();

        head = bruteForce(head);
        head.print();
        head = reverseRecursive(head);
        head.print();
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, temp, curr = head;
        // 1->2->3->4->null
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;

            curr = temp;
        }
        return prev;
    }


    private static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }

    private static ListNode bruteForce(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.v);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.v = stack.pop();
            temp = temp.next;
        }
        return head;
    }
}
