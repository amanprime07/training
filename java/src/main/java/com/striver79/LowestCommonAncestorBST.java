package com.striver79;

import com.training.trees.TreeNode;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode root = TreeNode.bst1();
        System.out.println(lowestCommonAncestor(root, root.left, root.right).val); // 4
        System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right).val); //2
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] lca = {root};
        lca(root, p, q, lca);
        return lca[0];
    }

    private static void lca(TreeNode root, TreeNode p, TreeNode q, TreeNode[] lca) {
        if (root == null) {
            return;
        }

        lca[0] = root;
        if (p.val == root.val && q.val == root.val) {
            return;
        }

        if (p.val < root.val && q.val < root.val) {
            // lca in left
            lca(root.left, p, q, lca);
        }

        if (p.val > root.val && q.val > root.val) {
            // lca in right
            lca(root.right, p, q, lca);
        }
    }
}
