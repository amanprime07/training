package com.training.trees;

/*
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * 110. Balanced Binary Tree
 * */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        boolean[]ans = {true};
        TreeNode node = TreeNode.tree1();
        node.right.right.right = new TreeNode(11);
        node.right.right.right.right = new TreeNode(12);
        isBalanced(ans, node);
        System.out.println(ans[0]);
    }

    private static int isBalanced(boolean[] ans, TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalanced(ans, root.left);
        int rightHeight = isBalanced(ans, root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
