package com.lyw.leetCode.hot100;
//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math Recursion 
// 👍 14802 👎 3245


import com.lyw.leetCode.model.ListNode;

/**
  * questionId：2
  * question：Add Two Numbers
  * date：2021-11-18 08:29:32
*/
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(solution.addTwoNumbers(l1, l2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//protected static class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {}
//
//    ListNode(int val) {this.val = val;}
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

    /**
     * make errors: 1、l1 val and l2 val should define new object, direct use l1.val and l2.val will produce NPE when l1 is null or l2 is null
     *              2、in while loop, cannot calculate current val and next ListNode object, only can calculate current val, and put the val to the result ListNode's next;
     *              3、should define a new object (temp ListNode) in calculation, cannot use res directly.the temp ListNode can point the next ListNode
     *
     */
    class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //init result, first value is zero
        ListNode res = new ListNode(0);
        //define a new ListNode object, it will point to a new ListNode for result's next value
        ListNode temp = res;
        int flag = 0;
        while (l1 != null || l2 != null) {
            //to avoid NPE, we should define arg to present listNode value
            int l1v = l1 == null ? 0 : l1.val;
            int l2v = l2 == null ? 0 : l2.val;
            //use / and % to calculate
            temp.next = new ListNode((l1v + l2v + flag) % 10);
            flag = (l1v + l2v + flag) / 10;
            //change next loop argument
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            temp = temp.next;
        }
        //deal with the final result
        if (flag == 1) {
            temp.next = new ListNode(1);
        }
        //because the first value is zero, so we should return the next listNode
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
