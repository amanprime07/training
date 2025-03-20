package com.training.trees;

/*
 *
 * https://leetcode.com/problems/same-tree/
 *
 * 100. Same Tree
 * */
public class SameTree {

    public static void main(String[] args) {
        TreeNode p = TreeNode.tree1();
        TreeNode q = null;
//        q.right.right.right = new TreeNode(5);
        System.out.println(isSameTree(p,q));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else {
            if (p == null) {
                return false;
            }
            if (q == null) {
                return false;
            }
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
