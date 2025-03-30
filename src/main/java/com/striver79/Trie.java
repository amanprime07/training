package com.striver79;


import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.startsWith("apl"));
        t.insert("bin");
        System.out.println(t.startsWith("bind"));
    }

    public void insert(String word) {
        TrieNode t = root;
        for (char c : word.toCharArray()) {
            if (!t.map.containsKey(c)) {
                t.map.put(c, new TrieNode());
            }
            t = t.map.get(c);
        }
        t.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode t = root;
        for (char c : word.toCharArray()) {
            if (!t.map.containsKey(c)) {
                return false;
            }
            t = t.map.get(c);
        }
        return t.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode t = root;
        for (char c : prefix.toCharArray()) {
            if (!t.map.containsKey(c)) {
                return false;
            }
            t = t.map.get(c);
        }
        return true;
    }


    private static class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;

        TrieNode() {
            this.map = new HashMap<>();
        }
    }
}
