//Given an m x n grid of characters board and a string word, return true if word
// exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, wher
//e adjacent cells are horizontally or vertically neighboring. The same letter cel
//l may not be used more than once. 
//
// 
// Example 1: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a l
//arger board? 
// Related Topics Array Backtracking Matrix 
// 👍 9136 👎 348


package com.lyw.leetCode.editor.en.matrix;


//Java：T_79_Word Search
public class T_79_WordSearch {
    public static void main(String[] args) {
        Solution solution = new T_79_WordSearch().new Solution();
        // TO TEST
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        String word = "ABCCED";
        String word = "ABCB";
        System.out.println(solution.exist(board, word));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //对于board数组，能够组成word时，word字符对于的位置设置为true
        boolean[][] visited;
        //回溯，时间复杂度O(mn*3^l), 空间复杂度O(mn),mn为board大小，l为word长度
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length < 1 || board[0].length < 1 || word == null || word.length() < 1) {
                return false;
            }
            visited = new boolean[board.length][board[0].length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    //单词第一个字符匹配时递归寻找后续字符
                    if (word.charAt(0) == board[i][j] && process(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        //寻找后续字符
        public boolean process(char[][] board, int i, int j, String word, int index) {
            //单词匹配完
            if (index == word.length()) {
                return true;
            }
            //i j超出边界值或者ij位置字符和单词匹配不上，或者ij位置已经匹配过(一个位置只能使用一次)返回false
            if (i >= board.length || i < 0
                    || j >= board[0].length || j < 0
                    || board[i][j] != word.charAt(index)
                    || visited[i][j]) {
                return false;
            }
            //ij位置匹配上index位置的字符，visited中对应位置设置为true
            visited[i][j] = true;
            //上下左右寻找单词的下一个字符，任何一个方向找到就返回true
            if (process(board, i + 1, j, word, index + 1)
                    || process(board, i - 1, j, word, index + 1)
                    || process(board, i, j + 1, word, index + 1)
                    || process(board, i, j - 1, word, index + 1)) {
                return true;
            }
            //ij位置不满word的匹配，设置为false
            visited[i][j] = false;
            //匹配不上，返回false
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}