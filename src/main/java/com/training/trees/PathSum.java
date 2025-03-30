package com.training.trees;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = TreeNode.tree1();
        System.out.println(hasPathSum(root, 8));
    }

    private static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        target -= root.val;
        if (root.left == null && root.right == null) {
            return target == 0;
        }
        return hasPathSum(root.left, target) || hasPathSum(root.right, target);
    }

}
