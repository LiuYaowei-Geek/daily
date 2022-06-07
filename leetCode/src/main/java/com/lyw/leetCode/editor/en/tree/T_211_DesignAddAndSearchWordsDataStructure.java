//Design a data structure that supports adding new words and finding if a string
// matches any previously added string. 
//
// Implement the WordDictionary class: 
//
// 
// WordDictionary() Initializes the object. 
// void addWord(word) Adds word to the data structure, it can be matched later. 
//
// bool search(word) Returns true if there is any string in the data structure t
//hat matches word or false otherwise. word may contain dots '.' where dots can be
// matched with any letter. 
// 
//
// 
// Example: 
//
// 
//Input
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//Output
//[null,null,null,null,false,true,true,true]
//
//Explanation
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 25 
// word in addWord consists of lowercase English letters. 
// word in search consist of '.' or lowercase English letters. 
// There will be at most 3 dots in word for search queries. 
// At most 104 calls will be made to addWord and search. 
// 
// Related Topics String Depth-First Search Design Trie 
// 👍 4910 👎 221


package com.lyw.leetCode.editor.en.tree;

//Java：T_211_Design Add and Search Words Data Structure
public class T_211_DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
//        Solution solution = new T_211_DesignAddAndSearchWordsDataStructure().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        class TrieNode {
            public char val;
            public TrieNode[] children = new TrieNode[26];
            public boolean isWord;

            public TrieNode() {
            }

            public TrieNode(char c) {
                this.val = c;
            }
        }

        public TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            return match(word, 0, root);
        }

        private boolean match(String word, int index, TrieNode node) {
            if (index == word.length()) {
                return node.isWord;
            }
            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    TrieNode child = node.children[i];
                    if (child != null && match(word, index + 1, child)) {
                        return true;
                    }
                }
            } else {
                TrieNode child = node.children[c - 'a'];
                if (child != null && match(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}