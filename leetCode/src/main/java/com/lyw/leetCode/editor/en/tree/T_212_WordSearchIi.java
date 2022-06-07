//Given an m x n board of characters and a list of strings words, return all wor
//ds on the board. 
//
// Each word must be constructed from letters of sequentially adjacent cells, wh
//ere adjacent cells are horizontally or vertically neighboring. The same letter c
//ell may not be used more than once in a word. 
//
// 
// Example 1: 
//
// 
//Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f"
//,"l","v"]], words = ["oath","pea","eat","rain"]
//Output: ["eat","oath"]
// 
//
// Example 2: 
//
// 
//Input: board = [["a","b"],["c","d"]], words = ["abcb"]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] is a lowercase English letter. 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] consists of lowercase English letters. 
// All the strings of words are unique. 
// 
// Related Topics Array String Backtracking Trie Matrix 
// 👍 6065 👎 241


package com.lyw.leetCode.editor.en.tree;

import java.util.ArrayList;
import java.util.List;

//Java：T_212_Word Search II
public class T_212_WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new T_212_WordSearchIi().new Solution();
        // TO TEST
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(board, words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 回溯+字典树
     * 时间复杂度：O(m×n×3^(l-1))，其中 m 是二维网格的高度，n 是二维网格的宽度，l是最长单词的长度。我们需要遍历 m×n 个单元格，每个单元格最多需要遍历4×3^(l-1)条路径。
     * <p>
     * 空间复杂度：O(k×l)，其中 k 是 words 的长度，l是最长单词的长度。最坏情况下，我们需要 O(k×l) 用于存储前缀树。
     */
    class Solution {

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            String word;
        }

        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            TrieNode root = buildTrie(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, root, res);
                }
            }
            return res;
        }

        private TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();
            for (String str : words) {
                TrieNode cur = root;
                for (char c : str.toCharArray()) {
                    int index = c - 'a';
                    if (cur.next[index] == null) {
                        cur.next[index] = new TrieNode();
                    }
                    cur = cur.next[index];
                }
                //在单词结束的字符位置记录单词
                cur.word = str;
            }
            return root;
        }

        private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
            char c = board[i][j];
            //表格中的字符c不是单词的前缀直接返回
            if (c == '#' || node.next[c - 'a'] == null) {
                return;
            }
            //表格中的字符c是单词的前缀，继续深度遍历
            node = node.next[c - 'a'];
            //走到单词结束位子
            if (node.word != null) {
                //添加单词
                res.add(node.word);
                //避免同一个单词被添加两遍
                node.word = null;
            }
            //同一个单元格内的字母在一个单词中不能被重复使用，所以用过的临时标记为#，以避免再次经过该单元格
            board[i][j] = '#';
            //上下左右深度遍历
            if (i > 0) {
                dfs(board, i - 1, j, node, res);
            }
            if (j > 0) {
                dfs(board, i, j - 1, node, res);
            }
            if (i < board.length - 1) {
                dfs(board, i + 1, j, node, res);
            }
            if (j < board[0].length - 1) {
                dfs(board, i, j + 1, node, res);
            }
            //还原临时标记为#的格子
            board[i][j] = c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}