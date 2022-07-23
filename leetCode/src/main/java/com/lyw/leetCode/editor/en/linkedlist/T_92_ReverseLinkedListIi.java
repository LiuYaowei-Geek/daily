//Given the head of a singly linked list and two integers left and right where l
//eft <= right, reverse the nodes of the list from position left to position right
//, and return the reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//Follow up: Could you do it in one pass? Related Topics Linked List 
// 👍 7506 👎 327


package com.lyw.leetCode.editor.en.linkedlist;

import com.lyw.leetCode.model.ListNode;

//Java：T_92_Reverse Linked List II
public class T_92_ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new T_92_ReverseLinkedListIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode start = dummy;
            int i = 1;
            while (i < left) {
                start = start.next;
                i++;
            }
            ListNode end = start;
            while (i <= right) {
                end = end.next;
                i++;
            }
            ListNode node = start.next;
            start.next = null;
            ListNode temp = end.next;
            end.next = null;
            ListNode reverseNode = reverse(node);
            start.next = reverseNode;
            node.next = temp;
            return dummy.next;
        }

        private ListNode reverse(ListNode node) {
            ListNode res = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = res;
                res = node;
                node = next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}