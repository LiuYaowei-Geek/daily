package com.lyw.leetCode.hot100;
//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics Linked List Two Pointers 
// 👍 8868 👎 423

import com.lyw.leetCode.model.ListNode;

/**
  * questionId：19
  * question：Remove Nth Node From End of List
  * date：2022-02-21 19:14:07
*/
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        System.out.println(solution.removeNthFromEnd(head, 2));
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        //后遍历的对象
        ListNode secondRun = newHead;
        //先遍历的对象
        ListNode firstRun = newHead;

        //先移动n位
        while (n != 0) {
            firstRun = firstRun.next;
            n--;
        }

        //再移动(head.size - n)位
        while (firstRun.next != null) {
            firstRun = firstRun.next;
            secondRun = secondRun.next;
        }
        //更新next位子的对象
        secondRun.next = secondRun.next.next;
        //返回结果
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
