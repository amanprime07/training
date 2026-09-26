package com.training.doublyLinkedList;

import java.util.Stack;

public class ReverseDoublyLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Node head = Node.createList(arr);
        print(head);
        head = bruteForce(head);
        print(head);
        head = reverse(head);
        print(head);
    }

    // null<->1<->2<->3<->null
//    null<->1<->null
    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head, prev = null;

        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;

            curr = curr.prev;
        }
        return prev.prev;
    }

    private static Node bruteForce(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp.v);
            temp = temp.next;
        }
        Node newHead = new Node(stack.pop());
        temp = newHead;
        while (!stack.isEmpty()) {
            Node newNode = new Node(stack.pop());
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }

        return newHead;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.v + " ");
            head = head.next;
        }
        System.out.println();
    }
}
