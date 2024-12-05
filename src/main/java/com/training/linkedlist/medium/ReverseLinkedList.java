package com.training.linkedlist.medium;

import com.training.linkedlist.Node;

import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Node head = Node.createList(arr);
        head.print();
        head = reverse(head);
        head.print();

        head = bruteForce(head);
        head.print();
        head = reverseRecursive(head);
        head.print();
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null, temp, curr = head;
        // 1->2->3->4->null
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;

            curr = temp;
        }
        return prev;
    }


    private static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        Node temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }

    private static Node bruteForce(Node head) {
        Node temp = head;
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
