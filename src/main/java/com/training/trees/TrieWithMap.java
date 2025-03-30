package com.training.trees;

import java.util.HashMap;
import java.util.Map;

public class TrieWithMap {

    Map<Character, TrieWithMap> map;
    boolean isEnd = false;

    public static void main(String[] args) {
        TrieWithMap t = new TrieWithMap();
        t.insert("apple");
        System.out.println(t.search("apple"));
    }

    public TrieWithMap() {
        map = new HashMap<>();
    }

    public void insert(String word) {
        TrieWithMap t = this;
        for (char c : word.toCharArray()) {
            if(!t.map.containsKey(c)){
                t.map.put(c, new TrieWithMap());
            }
            t = t.map.get(c);
        }
        t.isEnd = true;
    }

    public boolean search(String word) {
        TrieWithMap t = this;
        for (char c : word.toCharArray()) {
            t = t.map.get(c);
            if (t == null) {
                return false;
            }
        }
        return t.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieWithMap t = this;
        for (char c : prefix.toCharArray()) {
            t = t.map.get(c);
            if (t == null) {
                return false;
            }
        }
        return true;
    }
}
