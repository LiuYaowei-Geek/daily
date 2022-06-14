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


package com.lyw.leetCode.editor.en.linkedlist;

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
        /**
         * 双指针，时间复杂度O(m+n)，空间复杂度O(1)
         * </p>
         * <li>1. 当两个链表都有值时，循环比较两个链表头结点的大小，将较小的节点拼接到合并后的链表上，并后移较小子链表和合并后链表的头结点位置</li>
         * <li>2. 当两个链表不全有值时，直接将剩余元素拼接到合并后链表的next节点</li>
         * <li>3. 返回虚拟头结点的next链表，即为合并后的链表</li>
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            //dummy是虚拟头结点，cur在循环中不断指向next节点
            ListNode dummy = new ListNode(), cur = dummy;
            //list1和list2都不为空时，循环比较两个链表的头结点
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    //next位置拼接较小的值
                    cur.next = list2;
                    //list2头结点后移一位
                    list2 = list2.next;
                } else {
                    cur.next = list1;
                    list1 = list1.next;
                }
                //cur指向当前拼接值的位置
                cur = cur.next;
            }
            //cur位置是当前较小值的位置，cur.next拼接上上剩余元素
            cur.next = list1 != null ? list1 : list2;
            //dummy只是占位符，两链表合并结果为next
            return dummy.next;
        }

        /**
         * 递归，时间复杂度O(m+n)， 空间复杂度O(m+n)
         * 两个链表的节点都会调用一次，递归栈空间也是m+n
         * </p>
         * <li>递归循环逻辑：返回较小结点链表的头结点，并将其next链表和另一个链接继续合并</li>
         * <li>递归终止条件：其中一个链表所有的节点都遍历完</li>
         */
        public ListNode mergeTwoListsWithRecursion(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val < list2.val) {
                list1.next = mergeTwoListsWithRecursion(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoListsWithRecursion(list1, list2.next);
                return list2;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}