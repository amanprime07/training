package com.training.linkedlist;

public class ListNode {
    public int v;
    public ListNode next;

    public ListNode(int v) {
        this.v = v;
        this.next = null;
    }

    public ListNode(int v, ListNode n) {
        this.v = v;
        this.next = n;
    }

    public static ListNode createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return v + " ";
    }

    public void print() {
        ListNode temp = this;
        while (temp != null) {
            System.out.print(temp.v + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}