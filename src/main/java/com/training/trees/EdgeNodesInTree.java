package com.training.trees;

import java.util.Stack;

public class EdgeNodesInTree {
    private static void printLeftEdgeNodes(StringTreeNode root) {
        while (root != null) {
            if (root.left != null || root.right != null)
                System.out.println(root.value);
            if (root.left == null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private static void printLeafNodes(StringTreeNode root) {
        if (root == null)
            return;
        if (root.right == null && root.left == null)
            System.out.println(root.value);
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    private static void printRightEdgeNodes(StringTreeNode root) {
        Stack<StringTreeNode> stack = new Stack<>();
        while (root != null) {
            if (root.left != null || root.right != null)
                stack.push(root);
            if (root.right == null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }
    }

    public static void main(String[] args) {
        StringTreeNode root = StringTreeNode.getTree();
        printNodesAntiClockWise(root);
    }

    private static void printNodesAntiClockWise(StringTreeNode root) {
        printLeftEdgeNodes(root);
        printLeafNodes(root);
        printRightEdgeNodes(root);
    }
}
