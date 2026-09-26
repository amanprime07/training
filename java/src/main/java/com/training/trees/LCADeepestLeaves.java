package com.training.trees;

import java.util.*;

public class LCADeepestLeaves {

    /*
     *    1
     *   / \
     *  2   3
     *  /\  /\
     * 4 5  6 7
     * */
    public static void main(String[] args) {
        TreeNode root = TreeNode.tree1();
        System.out.println(lcaDfs(root));
    }


    private static TreeNode lcaDfs(TreeNode root){
        return lca(root).node;
    }

    private static Pair lca(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }

        Pair left = lca(root.left);
        Pair right = lca(root.right);
        if (left.level > right.level) { // left tree is deepest
            return new Pair(left.level + 1, left.node);
        }

        if (left.level < right.level) { // right tree is deepest
            return new Pair(right.level + 1, right.node);
        }
        return new Pair(left.level + 1, root);
    }

    private record Pair(
            int level,
            TreeNode node) {
    }

    // find lca
    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val == root.val || q.val == root.val) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.left, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // find deepest nodes
    private static List<TreeNode> deepestLeaves(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            List<TreeNode> l = map.getOrDefault(p.level, new ArrayList<>());
            l.add(p.node);
            map.put(p.level, l);
            if (p.node.left != null) {
                q.add(new Pair(p.level + 1, p.node.left));
            }
            if (p.node.right != null) {
                q.add(new Pair(p.level + 1, p.node.right));
            }
        }
        int maxLevel = Integer.MIN_VALUE;
        List<TreeNode> deepestNodes = Collections.emptyList();
        for (Map.Entry<Integer, List<TreeNode>> e : map.entrySet()) {
            if (e.getKey() > maxLevel) {
                maxLevel = e.getKey();
                deepestNodes = e.getValue();
            }
        }
        return deepestNodes;
    }
}
