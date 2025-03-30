package com.training.trees;

/*
*
* 530. Minimum Absolute Difference in BST
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
* */
public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        TreeNode node = TreeNode.bst1();
        System.out.println(getMinimumDifference(node));
    }

    private static int getMinimumDifference(TreeNode root) {
        int[] ans = {Integer.MAX_VALUE};
        int[] prev = {-1};
        getMinimumDifference(root, ans, prev);
        return ans[0];
    }

    private static void getMinimumDifference(TreeNode root, int[] ans, int[] prev) {
        if (root == null) {
            return;
        }

        getMinimumDifference(root.left, ans, prev);
        if (prev[0] > -1) {
            ans[0] = Math.min(ans[0], Math.abs(root.val - prev[0]));
        }
        prev[0] = root.val;
        getMinimumDifference(root.right, ans, prev);
    }
}
