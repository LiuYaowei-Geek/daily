package com.lyw.leetCode.hot100;
//Given a linked list, swap every two adjacent nodes and return its head. You mu
//st solve the problem without modifying the values in the list's nodes (i.e., onl
//y nodes themselves may be changed.) 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
// Related Topics Linked List Recursion 
// 👍 6428 👎 282

import com.lyw.leetCode.model.ListNode;

/**
  * questionId：24
  * question：Swap Nodes in Pairs
  * date：2022-03-01 22:22:05
*/
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        System.out.println("Hello world");
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
    /**
     * 1、head = 1234, n = 234, head.next=234 = swap(34), n.next=head, n=
     * 2、head = 34, n = 4, head.next=4 = swap(null), n.next = head, n =
     * 3、swap(null) = null
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode res = head.next;
        head.next = swapPairs(head.next.next);
        res.next = head;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
