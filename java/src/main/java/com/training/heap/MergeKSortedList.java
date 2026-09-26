package com.training.heap;

import com.training.linkedlist.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode l1 = ListNode.createList(new int[]{1,4,5});
        ListNode l2 = ListNode.createList(new int[]{1,3,4});
        ListNode l3 = ListNode.createList(new int[]{2,6});
        ListNode[] listNodes = {l1, l2, l3};
        ListNode n = mergeKLists(listNodes);
        n.print();
    }

    private static ListNode mergeKLists(ListNode[] listNodes) {
        Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.v - b.v);
        for (ListNode n : listNodes) {
            q.offer(n);
        }
        ListNode first = null;
        ListNode last = null;
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            if (first == null) {
                first = node;
                last = node;
            } else {
                last.next = node;
                last = last.next;
            }
            if (node.next != null) {
                q.offer(node.next);
            }
        }
        return first;
    }
}
