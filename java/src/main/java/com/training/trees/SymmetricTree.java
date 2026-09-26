package com.training.trees;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.tree1();
        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private static boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
