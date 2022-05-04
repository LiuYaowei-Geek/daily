//You are given the heads of two sorted linked lists list1 and list2. 
//
// Merge the two lists in a one sorted list. The list should be made by splicing
// together the nodes of the first two lists. 
//
// Return the head of the merged linked list. 
//
// 
// Example 1: 
//
// 
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: list1 = [], list2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both list1 and list2 are sorted in non-decreasing order. 
// 
// Related Topics Linked List Recursion 
// 👍 11956 👎 1096


package com.lyw.leetCode.editor.en.recursion;

import com.lyw.leetCode.model.ListNode;

//Java：T_21_Merge Two Sorted Lists
public class T_21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new T_21_MergeTwoSortedLists().new Solution();
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
        //双指针，时间复杂度O(m+n)，空间复杂度O(1)
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode res = new ListNode();
            ListNode cur = res;
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    cur.next = list2;
                    list2 = list2.next;
                } else {
                    cur.next = list1;
                    list1 = list1.next;
                }
                cur = cur.next;
            }
            cur.next = list1 != null ? list1 : list2;
            return res.next;
        }

        /**
         * 递归，时间复杂度O(m+n)， 空间复杂度O(m+n)
         * 两个链表的节点都会调用一次，递归栈空间也是m+n
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists2(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists2(list1, list2.next);
                return list2;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}