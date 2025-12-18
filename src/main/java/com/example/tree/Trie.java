package com.example.tree;

class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
    }

    private Trie[] children;

    private boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie trie = this;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            Trie node = trie.children[c-'a'];
            if(node==null){
                trie.children[c-'a'] = new Trie();
                node = trie.children[c-'a'];
            }
            trie = node;
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = this;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            Trie node = trie.children[c-'a'];
            if(node==null){
                return false;
            }
            trie = node;
        }

        return trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie trie = this;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            Trie node = trie.children[c-'a'];
            if(node==null){
                return false;
            }
            trie = node;
        }
        return true;
    }
}

