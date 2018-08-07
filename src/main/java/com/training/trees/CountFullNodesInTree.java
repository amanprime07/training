package com.training.trees;

import java.util.Stack;

public class CountFullNodesInTree {

    private static int countFullNodesRecursive(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.left != null && root.right != null)
            count++;
        count += countFullNodesRecursive(root.left) + countFullNodesRecursive(root.right);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println(countFullNodesRecursive(root));
        System.out.println(countFullNodesIterative(root));
        TreeNode root1 = TreeNode.getTree1();
        System.out.println(countFullNodesRecursive(root1));
        System.out.println(countFullNodesIterative(root1));

    }

    private static int countFullNodesIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.left != null && root.right != null) {
                count++;
            }
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
        return count;
    }
}
