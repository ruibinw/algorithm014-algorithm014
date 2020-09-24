package trie_prefix_tree;

class Trie {
    private boolean isEnd;
    private Trie[] next;

    // Initialize your data structure here.
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int ci = word.charAt(i) - 'a';
            if (node.next[ci] == null)
                node.next[ci] = new Trie();
            node = node.next[ci];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            node = node.next[word.charAt(i) - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
