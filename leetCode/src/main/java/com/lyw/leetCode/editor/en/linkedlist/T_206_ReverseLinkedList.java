//Given the head of a singly linked list, reverse the list, and return the rever
//sed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. C
//ould you implement both? 
// Related Topics Linked List Recursion 
// 👍 11678 👎 201


package com.lyw.leetCode.editor.en.linkedlist;

import com.lyw.leetCode.model.ListNode;

import java.util.Stack;

//Java：T_206_Reverse Linked List
public class T_206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new T_206_ReverseLinkedList().new Solution();
        // TO TEST
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(solution.reverseList3(head));

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
        //利用栈，时间复杂度O(n)， 空间复杂度O(n)
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            ListNode res = new ListNode();
            //cur初始要指向res，不能指向res.next，因为res.next为空还没有内存地址，会关联不上
            ListNode cur = res;
            while (!stack.isEmpty()) {
                //先初始化cur.next，创建内存地址
                cur.next = new ListNode(stack.pop());
                //cur执行next的内存地址
                cur = cur.next;
            }
            return res.next;
        }

        //遍历，时间复杂度O(n)， 空间复杂度O(1)
        //利用内存地址的引用
        //返回值初始化为null，每次弹出链表头节点，并暂存next链表；将res拼接到头节点后，res再指向头节点的地址；最后head指向next链表继续遍历
        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode res = null;
            while (head != null) {
                //暂存head.next
                ListNode next = head.next;
                //将res拼接到head后
                head.next = res;
                //res指向head
                res = head;
                //指向next，继续遍历
                head = next;
            }
            return res;
        }

        /**
         * 递归，从后往前反转，时间复杂度O(n), 空间复杂度O(n),递归调用的栈空间最大为n
         * 1 2 3 4 5
         * <p>
         * 1  54321
         * 2  5432
         * 3  543
         * 4  54
         * 5  5
         */
        public ListNode reverseList3(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //res指向next
            ListNode res = reverseList3(head.next);
            //将链表形成环
            // head->next->null
            // head->next->head
            head.next.next = head;
            //断开环，实现反转，next->head
            head.next = null;
            //
            return res;
        }


        /**
         * 递归，从前往后反转，时间复杂度O(n), 空间复杂度O(n),递归调用的栈空间最大为n
         *
         * @param head
         * @return
         */
        public ListNode reverseList4(ListNode head) {
            return reverse(head, null);
        }

        public ListNode reverse(ListNode head, ListNode newHead) {
            if (head == null) {
                return newHead;
            }
            //暂存next链表，后续进行遍历
            ListNode next = head.next;
            //逐个节点反转，
            head.next = newHead;
            return reverse(next, head);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}