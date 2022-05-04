//Given the head of a linked list, return the list after sorting it in ascending
// order. 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
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
// The number of nodes in the list is in the range [0, 5 * 104]. 
// -105 <= Node.val <= 105 
// 
//
// 
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
// Related Topics Linked List Two Pointers Divide and Conquer Sorting Merge Sort
// 
// 👍 7047 👎 230


package com.lyw.leetCode.editor.en;

import com.lyw.leetCode.model.ListNode;

import java.util.PriorityQueue;

//Java：T_148_Sort List
public class T_148_SortList{
    public static void main(String[] args) {
        Solution solution = new T_148_SortList().new Solution();
        // TO TEST
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        System.out.println(solution.sortList(head));
        System.out.println(solution.sortList2(head2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //小根堆
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while (head != null) {
            priorityQueue.add(head.val);
            head = head.next;
        }
        ListNode res = new ListNode();
        ListNode cur = res;
        while (!priorityQueue.isEmpty()) {
            cur.next = new ListNode(priorityQueue.poll());
            cur = cur.next;
        }
        return res.next;
    }


    //归并排序  时间复杂度O(nlogn) 空间复杂度O(logn)
    //归并排序时间复杂度O(nlogn)，递归空间复杂度O(logn)
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //slow前一个节点
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;

        //快慢指针找链表中点
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        //将链表拆成head->pre 和 slow->end两部分
        pre.next = null;


        //使用递归进行归并处理
        ListNode left = sortList2(head);
        ListNode right = sortList2(slow);
        //递归中，每次拆成两部分后进行合并
        return merge(left, right);
    }

    //将两个有序链表合并成一个有序链表
    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        //双指针，一起遍历left和right
        ListNode p1 = left;
        ListNode p2 = right;
        //返回结果res.next
        ListNode res = new ListNode();
        //使用cur进行遍历，避免res值在遍历过程中改变，导致返回错误
        ListNode cur = res;
        //p1 p2都不为空时，遍历比较p1 p2大小。需要注意，每次移动完后都得移动p1 p2 和cur的位置
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        //两个while只会进一个，将没拼接完的链表继续拼接，注意循环中需要移动cur 和p的位置
        if (p1 != null) {
            cur.next = p1;
        }

        if (p2 != null) {
            cur.next = p2;
        }
        //返回res.next
        return res.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
    //1 2 3 4 5
    //1 1   2 3    3 5
    //1 2 3 4
    //1 1   2 3  3 null
    //3 4 5
    //33  45
    //3  44

    //1 2 3 4
    //11  23  3null 2
    //12 34


}