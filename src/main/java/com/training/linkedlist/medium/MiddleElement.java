package com.training.linkedlist.medium;

import com.training.linkedlist.Node;

public class MiddleElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = Node.createList(arr);
        System.out.println(bruteForce(head));
        System.out.println(middleNode(head));
    }


    private static Node bruteForce(Node head) {
        int count = 0;
        Node temp = head;
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

    private static Node middleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
