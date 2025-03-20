package com.training.trees;


import java.util.Stack;

/*
* 1448. Count Good Nodes in Binary Tree
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
* */
public class GoodNodesBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(5);
//        node.left.left = new TreeNode(-1);
        System.out.println(goodNodesRecursion(node));
        System.out.println(goodNodesIterative(node));
    }

    private static int goodNodesRecursion(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return goodNodesRecursion(root, max);
    }

    private static int goodNodesRecursion(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val >= max) {
            count++;
            max = root.val;
        }
        int leftCount = goodNodesRecursion(root.left, max);
        int rightCount = goodNodesRecursion(root.right, max);
        return count + leftCount + rightCount;
    }

    private static int goodNodesIterative(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        stack.push(new Pair(root, max));
        int goodNodesCount = 0;
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            max = p.max;
            TreeNode node = p.node;
            if (max <= node.val) {
                goodNodesCount++;
                max = node.val;
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, max));
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, max));
            }
        }
        return goodNodesCount;
    }

    private static class Pair {
        TreeNode node;
        int max;

        public Pair(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }
}
