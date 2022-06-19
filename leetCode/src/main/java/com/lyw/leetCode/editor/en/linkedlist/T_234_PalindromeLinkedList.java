//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 105]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 
// 👍 9283 👎 572


package com.lyw.leetCode.editor.en.linkedlist;

import com.lyw.leetCode.model.ListNode;

import java.util.Stack;

//Java：T_234_Palindrome Linked List
public class T_234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new T_234_PalindromeLinkedList().new Solution();
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
        //时间复杂度O(n)， 空间复杂度O(1)
        public boolean isPalindrome(ListNode head) {
            ListNode mid = getMid(head);
            ListNode midReverse = reverse(mid);
            while (head != null && midReverse != null) {
                if (head.val != midReverse.val) {
                    return false;
                }
                head = head.next;
                midReverse = midReverse.next;
            }
            return true;
        }

        //找链表中点
        //1234，mid=3
        //12345, mid=3
        private ListNode getMid(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        //翻转链表
        private ListNode reverse(ListNode head) {
            ListNode res = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = res;
                res = head;
                head = next;
            }
            return res;
        }

        private boolean isPalindromeWithStack(ListNode node) {
            Stack<Integer> stack = new Stack<>();
            ListNode cur = node;
            while (cur != null) {
                stack.push(cur.val);
                cur = cur.next;

            }

            while (!stack.isEmpty()) {
                if (node.val != stack.pop()) {
                    return false;
                }
                node = node.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}