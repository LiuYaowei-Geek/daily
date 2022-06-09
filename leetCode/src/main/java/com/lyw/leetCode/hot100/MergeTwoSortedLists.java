package com.lyw.leetCode.hot100;
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
// 👍 10696 👎 997


import com.lyw.leetCode.model.ListNode;

/**
  * questionId：21
  * question：Merge Two Sorted Lists
  * date：2022-02-22 22:02:46
*/
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(4)));
        System.out.println(solution.mergeTwoLists(l1, l2));
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
    /**
     * 循环赋值next，并拼接当前val
     * [0]-l1:1 3 4   l2:1 2 4
     * [1]-l2.next = merge(134, 24)  return:l2   112344
     * [2]-l1.next = merge(34, 24)   return:l1   12344
     * [3]-l2.next = merge(34, 4)    return:l2   2344
     * [4]-l1.next = merge(4, 4)     return:l1   344
     * [5]-l2.next = merge(4, null)  return:l2   44
     * [6]-          merge(4, null)  return l1   4
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    public ListNode mergeTwoListsWithLoop(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;

        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l1.val >= l2.val)) {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            }
        }
        return fakeHead.next;
    }
}
    //leetcode submit region end(Prohibit modification and deletion)

} 
