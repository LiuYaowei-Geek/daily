//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 104 
// 0 <= lists[i].length <= 500 
// -104 <= lists[i][j] <= 104 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 104. 
// 
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge Sor
//t 
// 👍 12008 👎 469


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.ListNode;

import java.util.PriorityQueue;

//Java：T_23_Merge k Sorted Lists
public class T_23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new T_23_MergeKSortedLists().new Solution();
        // TO TEST
        ListNode[] lists = new ListNode[]{new ListNode(-2, new ListNode(-1, new ListNode(-1, new ListNode(-1)))), null};
        System.out.println(solution.mergeKLists4(lists));
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
         * 顺序合并
         * 时间复杂度O((k^2)n),k为List长度，n为每个链表的长度
         * 空间复杂度O(1)
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }

            if (lists.length < 2) {
                return lists[0];
            }
            ListNode res = null;
            for (ListNode cur : lists) {
                res = merge(res, cur);
            }
            return res;
        }


        /**
         * 分治合并，时间复杂度O(knlogk), 空间复杂度O(logk)
         * 每次把目标分成两部分就行合并
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists2(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }

            if (lists.length < 2) {
                return lists[0];
            }
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }
            int mid = start + (end - start) / 2;
            ListNode list1 = merge(lists, start, mid);
            ListNode list2 = merge(lists, mid + 1, end);
            return merge(list1, list2);
        }


        //合并两个有序链表
        public ListNode merge(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val < list2.val) {
                list1.next = merge(list1.next, list2);
                return list1;
            } else {
                list2.next = merge(list1, list2.next);
                return list2;
            }
        }

        /**
         * 小根堆，时间复杂度O(knlogk)， 空间复杂度O(k)
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists3(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }

            if (lists.length < 2) {
                return lists[0];
            }
            PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
            for (ListNode cur : lists) {
                //需要判断非空，空的插入会NPE
                //插入是按照数组中每个元素头节点的大小插入的
                if (cur != null) {
                    heap.add(cur);
                }
            }
            ListNode res = new ListNode();
            ListNode cur = res;
            while (!heap.isEmpty()) {
                //heap中弹出的是链表，1->2->3
                cur.next = heap.poll();
                cur = cur.next;
                //头节点处理完后，需要将剩下的节点放入队列中继续处理
                if (cur.next != null) {
                    heap.add(cur.next);
                }
            }
            return res.next;
        }

        public ListNode mergeKLists4(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }

            if (lists.length < 2) {
                return lists[0];
            }
            PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
            for (ListNode cur : lists) {
                //需要判断非空，空的插入会NPE
                //循环插入每个链表的每个节点
                while (cur != null) {
                    //cur = 1->2->3
                    //next = 2->3
                    ListNode next = cur.next;
                    //需要断开链表，不然后续串连节点时会出现环
                    cur.next = null;
                    heap.add(cur);
                    cur = next;
                }
            }
            ListNode res = new ListNode();
            ListNode cur = res;
            while (!heap.isEmpty()) {
                //heap中弹出的是链表，1->2->3
                cur.next = heap.poll();
                cur = cur.next;
            }
            return res.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}