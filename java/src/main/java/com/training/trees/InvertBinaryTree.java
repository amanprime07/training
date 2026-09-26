package com.training.trees;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode inverted = invert(root);

    }

    private static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        invert(root.left);
        invert(root.right);
        return root;
    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


}
