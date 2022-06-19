//Given the head of a linked list and a value x, partition it such that all node
//s less than x come before nodes greater than or equal to x. 
//
// You should preserve the original relative order of the nodes in each of the t
//wo partitions. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [2,1], x = 2
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 200]. 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics Linked List Two Pointers 
// 👍 3566 👎 495


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.ListNode;

//Java：T_86_Partition List
public class T_86_PartitionList {
    public static void main(String[] args) {
        Solution solution = new T_86_PartitionList().new Solution();
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
         * 链表拆分为小于区和大于区，并且元素位置相对不变
         * 时间复杂度O(n)，空间复杂度O(1)
         * 1. 新建小于区和大于区的头尾节点
         * 2. 区间为空时，区间头尾节点都指向当前节点
         * 3. 区间不为空时，区间尾节点都指向当前节点，并且右移尾节点到尾部
         * 4. 前一个区间不为空时，将相邻区间的头尾相连
         * 5. 判断个区间头节点是否为空，返回结果
         */
        public ListNode partition(ListNode head, int x) {
            //小于区的头尾和大于区的头尾
            ListNode smallHead = null, smallTail = null, bigHead = null, bigTail = null;

            while (head != null) {
                //记录next节点
                ListNode next = head.next;
                //断开节点
                head.next = null;

                //小于区
                if (head.val < x) {
                    //小于区为空时，小于区的头尾都指向head
                    if (smallHead == null) {
                        smallHead = head;
                        smallTail = head;
                    } else {
                        //小于区不为空时，小于区的尾节点next指向head，然后再右移尾节点到尾部
                        smallTail.next = head;
                        smallTail = head;
                    }
                    //大于等于区
                } else {
                    if (bigHead == null) {
                        bigHead = head;
                        bigTail = head;
                    } else {
                        bigTail.next = head;
                        bigTail = head;
                    }
                }
                head = next;
            }

            //小于区不为空时，将小于区的尾和大于区的头连接起来
            if (smallTail != null) {
                smallTail.next = bigHead;
            }
            //返回结果
            return smallHead != null ? smallHead : bigHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}