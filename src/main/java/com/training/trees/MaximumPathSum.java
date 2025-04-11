package com.training.trees;

public class MaximumPathSum {

    public static void main(String[] args) {
        TreeNode node = TreeNode.tree1();
        System.out.println(maxPathSum(node));
    }

    private static int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        maxPathSum(root, maxSum);
        return maxSum[0];
    }

    private static int maxPathSum(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int leftSum = maxPathSum(root.left, maxSum);
        int rightSum = maxPathSum(root.right, maxSum);
        int sum = root.val + leftSum + rightSum;
        maxSum[0] = Math.max(maxSum[0], sum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
