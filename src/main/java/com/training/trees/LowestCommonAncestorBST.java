package com.training.trees;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode root = TreeNode.bst1();
        TreeNode lca = lowestCommonAncestor(root, root.left.left, root.left.right);
        assert lca == root.left;

        lca = lowestCommonAncestor(root, root.left.left, root.right);
        assert lca == root;
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] lca = {root};
        lowestCommonAncestor(root, p, q, lca);
        return lca[0];
    }

    private static void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode[] lca) {
        if (root == null) {
            return;
        }
        lca[0] = root;
        if (root.val == p.val || root.val == q.val) {
            return;
        }

        if (p.val > root.val && q.val > root.val) {
            lowestCommonAncestor(root.right, p, q, lca);
        }

        if (p.val < root.val && q.val < root.val) {
            lowestCommonAncestor(root.left, p, q, lca);
        }


    }
}
