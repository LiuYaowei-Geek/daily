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


package com.lyw.leetCode.editor.en.linkedlist;

import com.lyw.leetCode.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

//Java：T_143_Reorder List
public class T_143_ReorderList {
    public static void main(String[] args) {
        Solution solution = new T_143_ReorderList().new Solution();
        // TO TEST
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
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
            //取mid.next
            ListNode mid = getMid(head).next;
            //在mid处断开head，不直接使用mid.next = null，避免mid链表数据变化
            getMid(head).next = null;
            //翻转mid链表
            mid = reverse(mid);
            //合并head和mid
            merge(head, mid);

            System.out.println(head);
        }

        //快慢直接找链表中点
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

        //初始化返回值res为null
        //将head头结点拼接res
        //head指针后移
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

        //链表错位合并
        //123  54
        //154  523  =>  1523
        //24   43   =>  15243
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

        /**
         * 使用队列，每次弹出头尾拼接
         * 组装队列时，需要断开链表，避免出现环形链表
         * @param head
         */
        public void reorderListWithDeque(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }
            Deque<ListNode> deque = new LinkedList<>();
            while (head != null) {
                ListNode next = head.next;
                head.next = null;
                deque.add(head);
                head = next;
            }

            ListNode newHead = new ListNode(0, head), cur = newHead;
            while (!deque.isEmpty()) {
                cur.next = deque.pollFirst();
                cur.next.next = deque.pollLast();
                cur = cur.next.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}