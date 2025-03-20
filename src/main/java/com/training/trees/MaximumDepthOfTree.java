package com.training.trees;

public class MaximumDepthOfTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.tree1();
        root.right.right.right = new TreeNode(4);
        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1+Math.max(leftHeight, rightHeight);
    }
}
