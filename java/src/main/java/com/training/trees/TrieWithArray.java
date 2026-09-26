package com.training.trees;

public class TrieWithArray {

    TrieWithArray[] arr;
    boolean isEnd = false;

    public TrieWithArray() {
        arr = new TrieWithArray[26];
    }

    public static void main(String[] args) {
        TrieWithArray t = new TrieWithArray();
        t.insert("apple");
        System.out.println(t.search("apple"));
    }

    public void insert(String word) {
        TrieWithArray t = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (t.arr[idx] == null) {
                t.arr[idx] = new TrieWithArray();
            }
            t = t.arr[idx];
        }
        t.isEnd = true;
    }

    public boolean search(String word) {
        TrieWithArray t = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            t = t.arr[idx];
            if (t == null) {
                return false;
            }
        }
        return t.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieWithArray t = this;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            t = t.arr[idx];
            if (t == null) {
                return false;
            }
        }
        return true;
    }
}
