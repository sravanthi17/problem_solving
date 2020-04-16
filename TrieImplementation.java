/* Trie Implementation */
public class TrieImplementation {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("app");
    }

    static class TrieNode {
        TrieNode[] links;
        boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public boolean containsChild(char charAt) {
            return links != null && links[charAt - 'a'] != null;
        }

        public void addChild(char child, TrieNode node) {
            links[child - 'a'] = node;
        }

        public TrieNode fetchNode(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    static class Trie {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char charAt = word.charAt(i);
                if (!node.containsChild(charAt)) {
                    node.addChild(charAt, new TrieNode());
                }
                node = node.fetchNode(charAt);
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsChild(curLetter)) {
                    node = node.fetchNode(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }
}
