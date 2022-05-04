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
// 👍 9770 👎 466


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.ListNode;

import javax.swing.event.ListDataEvent;
import java.util.LinkedList;
import java.util.Queue;

//Java：T_19_Remove Nth Node From End of List
public class T_19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new T_19_RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solution.removeNthFromEnd(head, 2));

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
         * 队列
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n < 1) {
                return null;
            }
            Queue<ListNode> queue = new LinkedList<>();
            while (head != null) {
                ListNode next = head.next;
                head.next = null;
                queue.offer(head);
                head = next;
            }

            ListNode res = new ListNode();
            ListNode cur = res;
            int i = 0, size = queue.size();
            while (!queue.isEmpty()) {
                if (i++ == size - n) {
                    queue.poll();
                    continue;
                }
                cur.next = queue.poll();
                cur = cur.next;
            }
            return res.next;
        }

        public ListNode removeNthFromEnd2(ListNode head, int n) {
            if (head == null || n < 1) {
                return null;
            }

            ListNode res = new ListNode();
            ListNode cur = res;
            int length = getLength(head);
            for (int i = 0; i < length; i++) {
                ListNode next = head.next;
                head.next = null;
                if (i != length - n) {
                    cur.next = head;
                    cur = cur.next;
                }
                head = next;
            }
            return res.next;
        }

        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                length++
                ;
                head = head.next;
            }
            return length;
        }

        /**
         * 双指针，时间复杂度O(n),空间复杂度O(1), n指链表长度
         * fast先走n+1步，然后fast和slow同时走，当fast走到null节点时，slow到要去除节点的前一个节点
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd3(ListNode head, int n) {
            if (head == null || n < 1) {
                return null;
            }
            //初始化res，next指向head
            ListNode res = new ListNode(0, head);
            //初始化快慢指针
            ListNode slow = res, fast = res;


            //fast先走n+1步
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }

            //fast 和slow同时走length-n-1步，这时fast走到末尾，slow走到要去除节点的前一个节点
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //去除slow.next节点
            slow.next = slow.next.next;
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}