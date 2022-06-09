package com.lyw.leetCode.hot100;
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
// 👍 6871 👎 227


import com.lyw.leetCode.model.ListNode;

/**
  * questionId：148
  * question：Sort List
  * date：2022-03-22 14:51:02
*/
public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        System.out.println("Hello world");
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

    private class MergeHelper {
        public ListNode newHead;
        public ListNode newTail;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHeadOne = new ListNode(0);
        ListNode dummyHeadTwo = new ListNode(0);
        ListNode dummySortedHead = new ListNode(0);
        ListNode dummySortedLast = dummySortedHead;
        ListNode unvisitedNode = head;
        MergeHelper mergeRst = new MergeHelper();

        int listLength = 0;
        int level = 0;
        while (unvisitedNode != null && unvisitedNode.next != null) {
            unvisitedNode = addNode(dummyHeadOne, unvisitedNode, 1 << level);
            unvisitedNode = addNode(dummyHeadTwo, unvisitedNode, 1 << level);
            merge(dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
            dummySortedLast.next = mergeRst.newHead;
            dummySortedLast = mergeRst.newTail;
            listLength += 2;
        }
        if (unvisitedNode != null) {
            dummySortedLast.next = unvisitedNode;
            listLength++;
        }
        level++;

        while (listLength > 1 << level) {
            dummySortedLast = dummySortedHead;
            unvisitedNode = dummySortedHead.next;
            while (unvisitedNode != null) {
                unvisitedNode = addNode(dummyHeadOne, unvisitedNode, 1 << level);
                unvisitedNode = addNode(dummyHeadTwo, unvisitedNode, 1 << level);
                merge(dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
                dummySortedLast.next = mergeRst.newHead;
                dummySortedLast = mergeRst.newTail;
            }
            level++;
        }

        return dummySortedHead.next;
    }

    /**
     * merge listOne and listTwo.
     * Save the sorted list head into rst.newHead
     * Save the last node of the sorted list into rst.newTail
     */
    private void merge(ListNode listOne, ListNode listTwo, MergeHelper rst) {
        ListNode dummyHead = new ListNode(0);
        ListNode lastNode = dummyHead;
        while (listOne != null && listTwo != null) {
            if (listOne.val < listTwo.val) {
                lastNode.next = listOne;
                listOne = listOne.next;
            } else {
                lastNode.next = listTwo;
                listTwo = listTwo.next;
            }
            lastNode = lastNode.next;
        }

        while (listOne != null) {
            lastNode.next = listOne;
            listOne = listOne.next;
            lastNode = lastNode.next;
        }
        while (listTwo != null) {
            lastNode.next = listTwo;
            listTwo = listTwo.next;
            lastNode = lastNode.next;
        }
        rst.newHead = dummyHead.next;
        rst.newTail = lastNode;
    }

    /**
     * add at max #"count" nodes into "head" from "source"
     * return the new position of source after adding.
     */
    private ListNode addNode(ListNode head, ListNode source, int count) {
        while (count > 0 && source != null) {
            head.next = source;
            head = head.next;
            source = source.next;
            count--;
        }
        head.next = null;
        return source;
    }

    /*============================================分界线，上面非递归，下面是递归实现================================================*/

    public ListNode sortListWithRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // step 1. cut the list to two halves
        //长度为偶数时对半分，为奇数时(比如长度为5,分为2和3两部分)
        ListNode prev = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表断开为两部分，head-slow和slow-tail
        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortListWithRecursion(head);
        ListNode l2 = sortListWithRecursion(slow);

        // step 3. merge l1 and l2
        //return merge(l1, l2);
        return mergeWithRecursion(l1, l2);
    }

    /**
     * 合并两个有序链表
     * @param l1 有序链表
     * @param l2 有序链表
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        //l和p为两个头节点，p在循环过程中使用，l始终记录头结点
        ListNode l = new ListNode(0), p = l;

        //循环取l1和l2中较小的值，放在p的next节点
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            //p节点指针右移，指向p.next
            p = p.next;
        }
        //l1链表还有值，直接放入p.next
        if (l1 != null) {
            p.next = l1;
        }
        ////l1链表还有值，直接放入p.next。与上面的if互斥
        if (l2 != null) {
            p.next = l2;
        }
        //p节点在过程中不断拼接较小的值，l为其头节点
        return l.next;
    }

    /**
     * 使用递归合并两个有序链表
     * 1.return    merge({1, 3}, {2, 4})  => l1={1,2,3,4}
     * 2.l1.next = merge(3, {2, 4})       => l1.next={2,3,4}, l1={1,2,3,4}
     * 3.l2.next = merge(3, 4)            => l2.next={3,4},   l2={2,3,4}
     * 4.l1.next = merge(null, 4)         => l1.next=4,       l1={3, 4}
     * @param l1 有序链表
     * @param l2 有序链表
     * @return
     */
    private ListNode mergeWithRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeWithRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeWithRecursion(l1, l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
