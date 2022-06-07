//A trie (pronounced as "try") or prefix tree is a tree data structure used to e
//fficiently store and retrieve keys in a dataset of strings. There are various ap
//plications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (i
//.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously inser
//ted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 104 calls in total will be made to insert, search, and startsWith
//. 
// 
// Related Topics Hash Table String Design Trie 
// 👍 7134 👎 92


package com.lyw.leetCode.editor.en.tree;

//Java：T_208_Implement Trie (Prefix Tree)
public class T_208_ImplementTriePrefixTree {
    public static void main(String[] args) {
//        Solution solution = new T_208_ImplementTriePrefixTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Trie，又称前缀树或字典树，是一棵有根树，其每个节点包含以下字段：
     *
     * 指向子节点的指针数组children。对于本题而言，数组长度为 26，即小写英文字母的数量。此时children[0] 对应小写字母 a，children[1] 对应小写字母 b，…，children[25] 对应小写字母 z。
     * 布尔字段isEnd，表示该节点是否为字符串的结尾。
     *
     * 时间复杂度：初始化为 O(1)，其余操作为 O(∣S∣)，其中∣S∣ 是每次插入或查询的字符串的长度。
     *
     * 空间复杂度：O(∣T∣⋅Σ)，其中 ∣T∣ 为所有插入字符串的长度之和，Σ 为字符集的大小，本题 Σ=26。
     *
     */
    class Trie {

        class TrieNode {
            public char val;
            public boolean isWord;
            public TrieNode[] children = new TrieNode[26];

            public TrieNode() {
            }

            public TrieNode(char c) {
                this.val = c;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //'a'-'a'=0；c-'a'=c
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}