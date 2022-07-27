//You are given the head of a singly linked-list. The list can be represented as
//: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 104]. 
// 1 <= Node.val <= 1000 
// 
// Related Topics Linked List Two Pointers Stack Recursion 
// 👍 5786 👎 210


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.ListNode;

//Java：T_143_Reorder List
public class T_143_ReorderList {
    public static void main(String[] args) {
        Solution solution = new T_143_ReorderList().new Solution();
        // TO TEST
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        solution.reorderList(head);

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
        /**
         * 先找中点，再反转后半部分链表，最后将后半部分链表合并到前半部分链表上。
         * 时间复杂度O(n)， 空间复杂度O(1)
         *
         * @param head
         */
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            //不能直接ListNode mid = reverse(getMid(head).next)，这样会改变head链表数据。导致结果错误
            ListNode mid = getMid(head).next;
            getMid(head).next = null;
            mid = reverse(mid);
            merge(head, mid);

            System.out.println(head);
        }

        public ListNode getMid(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode res = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = res;
                res = head;
                head = next;
            }
            return res;
        }

        public void merge(ListNode l1, ListNode l2) {
            ListNode next1;
            ListNode next2;
            while (l1 != null && l2 != null) {
                next1 = l1.next;
                next2 = l2.next;

                l1.next = l2;
                l1 = next1;

                l2.next = l1;
                l2 = next2;
            }
        }
    }
    /**
     * 12  34
     *
     * 134
     */
//leetcode submit region end(Prohibit modification and deletion)

}