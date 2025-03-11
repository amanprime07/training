package com.training.trees;

public class PathSum {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.left.left.left = new Node(1);

        System.out.println(pathWithSum(root, 11));
        System.out.println(pathWithSum(root, 14));
        System.out.println(pathWithSum(root, 12));
        System.out.println(pathWithSum(root, 10));

    }

    private static boolean pathWithSum(Node root, int target) {
        return pathWithTargetSum(root, 0, target);
    }

    private static boolean pathWithTargetSum(Node root, int sum, int target) {
        if (root == null) {
            return false;
        }

        sum += root.value;
        if (root.left == null && root.right == null) {
            return sum == target;
        }
        return pathWithTargetSum(root.left, sum, target) || pathWithTargetSum(root.right, sum, target);
    }

    private static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
