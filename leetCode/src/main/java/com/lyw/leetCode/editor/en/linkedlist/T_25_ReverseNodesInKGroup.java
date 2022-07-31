//Given the head of a linked list, reverse the nodes of the list k at a time, an
//d return the modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may b
//e changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
// Follow-up: Can you solve the problem in O(1) extra memory space? 
// Related Topics Linked List Recursion 
// 👍 8143 👎 515


package com.lyw.leetCode.editor.en.linkedlist;

import com.lyw.leetCode.model.ListNode;

//Java：T_25_Reverse Nodes in k-Group
public class T_25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new T_25_ReverseNodesInKGroup().new Solution();
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

        public ListNode reverseKGroup2(ListNode head, int k) {
            int i = 1;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                if (i % k == 0) {
                    head = reverse(head, i - k + 1, i);
                }
                i++;
            }
            return head;
        }

        private ListNode reverse(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = dummy;
            int count = 1;
            while (pre != null && count < left) {
                pre = pre.next;
                count++;
            }
            ListNode preNext = pre.next;
            ListNode post = preNext;
            while (post != null && count < right) {
                post = post.next;
                count++;
            }
            ListNode postNext = post.next;
            post.next = null;
            pre.next = null;
            preNext = reverse(preNext);
            pre.next = preNext;
            //重点，不能直接preNext.next = postNext
            while (preNext.next != null) {
                preNext = preNext.next;
            }
            preNext.next = postNext;
            return dummy.next;
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1) {
                return head;
            }
            int i = 1;
            int size = getSize(head);
            System.out.println(size);
            while (i <= size) {
                if (i % k == 0) {
                    head = reverseRange(head, i - k + 1, i);
                }
                i++;
            }
            return head;
        }

        private ListNode reverseRange(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = dummy;
            int i = 1;
            while (i < left) {
                pre = pre.next;
                i++;
            }
            ListNode tail = pre;
            while (i <= right) {
                tail = tail.next;
                i++;
            }
            ListNode tailNext = tail.next;
            ListNode preNext = pre.next;
            tail.next = null;
            pre.next = null;
            ListNode reverse = reverse(preNext);
            pre.next = reverse;
            preNext.next = tailNext;
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

        private int getSize(ListNode head) {
            int i = 0;
            while (head != null) {
                i++;
                head = head.next;
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}