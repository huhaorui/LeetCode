package leetcode;

class Trie {
    Trie[] tries = new Trie[26];
    boolean exist = false;

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println(trie.search("hello"));
        System.out.println(!trie.search("hel"));
        System.out.println(trie.startsWith("hel"));
        System.out.println(!trie.startsWith("heool"));

    }

    private void insertToNode(Trie trie, String word, int position) {
        if (word.length() == position) {
            trie.exist = true;
            return;
        }
        int index = word.charAt(position) - 'a';
        if (trie.tries[index] == null) {
            trie.tries[index] = new Trie();
        }
        insertToNode(trie.tries[index], word, position + 1);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insertToNode(this, word, 0);
    }

    private boolean searchToNode(Trie trie, String word, int position) {
        if (word.length() == position) {
            return trie.exist;
        }
        int index = word.charAt(position) - 'a';
        if (trie.tries[index] == null) {
            return false;
        }
        return searchToNode(trie.tries[index], word, position + 1);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return searchToNode(this, word, 0);
    }

    private boolean startsWithToNode(Trie trie, String prefix, int position) {
        if (prefix.length() == position) {
            return true;
        }
        int index = prefix.charAt(position) - 'a';
        if (trie.tries[index] == null) {
            return false;
        }
        return startsWithToNode(trie.tries[index], prefix, position + 1);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWithToNode(this, prefix, 0);
    }
}

/*
  Your Trie object will be instantiated and called as such:
  Trie obj = new Trie();
  obj.insert(word);
  boolean param_2 = obj.search(word);
  boolean param_3 = obj.startsWith(prefix);
 */