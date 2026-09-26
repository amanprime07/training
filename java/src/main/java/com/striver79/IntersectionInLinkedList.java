package com.striver79;

import com.training.linkedlist.ListNode;

public class IntersectionInLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode l1 = ListNode.createList(arr);
        ListNode l2 = l1.next.next.next;
        ListNode intersect = intersection(l1, l2);
        System.out.println(intersect);
        l2 = l1;
        System.out.println(intersection(l1, l2));


        l2 = ListNode.createList(arr);
        System.out.println(intersection(l1, l2));
    }

    private static ListNode intersection(ListNode list1, ListNode list2) {
        int diff = difference(list1, list2);
        ListNode head1 = list1;
        ListNode head2 = list2;
        if (diff > 0) {
            while (diff-- != 0) {
                head1 = head1.next;
            }
        } else {
            while (diff++ != 0) {
                head2 = head2.next;
            }
        }

        while (head2 != null && head1 != null && head1 != head2) {
            head2 = head2.next;
            head1 = head1.next;
        }

        if (head2 != null && head1 != null) {
            return head2;
        }
        return null;
    }

    private static int difference(ListNode list1, ListNode list2) {
        int l1 = length(list1);
        int l2 = length(list2);
        return l1 - l2;
    }

    private static int length(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
