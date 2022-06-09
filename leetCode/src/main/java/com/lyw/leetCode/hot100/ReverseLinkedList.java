package com.lyw.leetCode.hot100;
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
// 👍 11122 👎 190

import com.lyw.leetCode.model.ListNode;

/**
  * questionId：206
  * question：Reverse Linked List
  * date：2022-03-25 11:02:22
*/
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode res = null;
        while (head != null) {
            res = new ListNode(head.val, res);;
            head = head.next;
        }
        return res;
    }

    public ListNode reverseListWithIteration(ListNode head) {
        //返回值
        ListNode newHead = null;
        while (head != null) {
            //记录head.next数据
            ListNode next = head.next;
            //把newHead数据拼接到当前节点后
            head.next = newHead;
            //组装后的head复制给newHead
            newHead = head;
            //循环对象赋值
            head = next;

        }
        return newHead;
    }

    public ListNode reverseListWithRecursion(ListNode head) {
        return reverseListInt(head, null);
    }

    /**
     * 1 2 3 4 5, null
     * 2 3 4 5, 1 null
     * 3 4 5, 2 1 null
     * 4 5, 3 2 1 null
     * 5, 4 3 2 1 null
     * null, 5 4 3 2 1 null
     * return: 5 4 3 2 1 null
     * @param head
     * @param newHead
     * @return
     */
    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        //记录head.next
        ListNode next = head.next;
        //head赋值
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
