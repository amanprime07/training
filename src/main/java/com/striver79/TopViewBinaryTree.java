package com.striver79;

import com.training.trees.TreeNode;

import java.util.*;

public class TopViewBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.bst1();
        System.out.println(topView(root));
    }

    private static List<Integer> topView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        while (!q.isEmpty()) {
          Pair p = q.poll();
          TreeNode node = p.node;
          int level = p.level;

          if(!map.containsKey(level)){
              map.put(level, node.val);
          }
          if(node.left!=null){
              q.offer(new Pair(level-1, node.left));
          }

            if(node.right!=null){
                q.offer(new Pair(level+1, node.right));
            }
        }

        list.addAll(map.values());
        return list;
    }

    private static class Pair {
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
}
