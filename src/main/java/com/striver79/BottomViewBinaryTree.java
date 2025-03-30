package com.striver79;

import com.training.trees.TreeNode;

import java.util.*;

public class BottomViewBinaryTree {

    public static void main(String[] args) {
        TreeNode node = TreeNode.bst1();
        System.out.println(bottomView(node));

    }

    private static List<Integer> bottomView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode tn = p.val;
            int level = p.level;
            map.put(level, tn.val);
            if (tn.left != null) {
                q.offer(new Pair(level - 1, tn.left));
            }
            if (tn.right != null) {
                q.offer(new Pair(level + 1, tn.right));
            }
        }
        list.addAll(map.values());
        return list;
    }

    private static class Pair {
        int level;
        TreeNode val;

        public Pair(int level, TreeNode val) {
            this.level = level;
            this.val = val;
        }
    }
}
