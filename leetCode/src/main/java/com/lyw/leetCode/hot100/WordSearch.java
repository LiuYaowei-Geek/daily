package com.lyw.leetCode.hot100;
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
// 👍 8722 👎 333

import java.util.Arrays;

/**
  * questionId：79
  * question：Word Search
  * date：2022-03-15 10:09:01
*/
public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        System.out.println(solution.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}},
                "ABCCED"));
        System.out.println(Arrays.toString(solution.visited[0]));
        System.out.println(Arrays.toString(solution.visited[1]));
        System.out.println(Arrays.toString(solution.visited[2]));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //board数组
    //'A','B','C','E'
    //'S','F','C','S'
    //'A','D','E','E'
    //visited数组
    //true, true, true, false
    //false,false,true, false
    //false,true, true, false
    //和board大小相等的二维数组，能匹配到单词的位子标记为true，不能匹配上的标记为false
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board 二维数组
     * @param word 目标单词
     * @param i 行位子
     * @param j 列位子
     * @param index 单词中char索引
     * @return
     */
    private boolean search(char[][] board, String word, int i, int j, int index) {
        //word比较完了
        if (index == word.length()) {
            return true;
        }
        //i j位子值和index位子值不相同，设置为false。或者i j大于数值长度
        if (i >= board.length || i < 0 ||
            j >= board[i].length || j < 0 ||
            board[i][j] != word.charAt(index) ||
            visited[i][j]) {
            return false;
        }
        //i j位子值和index位子值相同，设置为true
        visited[i][j] = true;
        //当前位子上边
        if (search(board, word, i - 1, j, index + 1) ||
            //当前位子下边
            search(board, word, i + 1, j, index + 1) ||
            //当前位子左边
            search(board, word, i, j - 1, index + 1) ||
            //当前位子右边
            search(board, word, i, j + 1, index + 1)) {
            //当前位子上下左右格子，有一个满足条件就返回true，代表i j位置的值等于index位子的字符
            return true;
        }
        //i j位子值和index位子值不相同，设置为false
        visited[i][j] = false;
        //i j位子值和index位子值不相同，返回false
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
