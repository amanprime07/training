package com.training.trees;

import java.util.Stack;

public class CountLeafNodesInTree {

    private static int countLeafNodesRecursive(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.left == null && root.right == null)
            count++;
        count += countLeafNodesRecursive(root.left) + countLeafNodesRecursive(root.right);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println(countLeafNodesRecursive(root));
        System.out.println(countLeafNodesIterative(root));
        TreeNode root1 = TreeNode.getTree1();
        System.out.println(countLeafNodesRecursive(root1));
        System.out.println(countLeafNodesIterative(root1));

    }

    private static int countLeafNodesIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.left == null && root.right == null) {
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
