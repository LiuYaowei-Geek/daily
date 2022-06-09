package com.lyw.leetCode.hot100;
//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
// Related Topics String 
// 👍 3173 👎 7440

/**
  * questionId：6
  * question：Zigzag Conversion
  * date：2022-01-05 22:38:12
*/
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int num = 2 * numRows - 2;
        int lie = s.length() / numRows;
        int yushu = s.length() % numRows;
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; yushu > 0 ? i <= lie : i < lie; i++) {
                if (i * num + j < s.length()) {
                    sb.append(s.charAt(i * num + j));
                }
                if ((j != 0 && j != numRows - 1) && (i * num + num - j < s.length())) {
                    sb.append(s.charAt(i * num + num - j));
                }
            }
        }
        return sb.toString();
    }
    //PAYPALISHIRING
    //PAAHHNNAPLSIIGYYIIRR
    //PAHNAPLSIIGYIR
}
//leetcode submit region end(Prohibit modification and deletion)

} 
