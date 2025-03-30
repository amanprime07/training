package com.training.linkedlist.medium;

import com.training.linkedlist.ListNode;

public class MiddleElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createList(arr);
        System.out.println(bruteForce(head));
        System.out.println(middleNode(head));
    }


    private static ListNode bruteForce(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = count / 2;
        temp = head;
        while (mid > 0) {
            temp = temp.next;
            mid--;
        }
        return temp;
    }

    private static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
