package com.lyw.leetCode.hot100;
//Given the heads of two singly linked-lists headA and headB, return the node at
// which the two lists intersect. If the two linked lists have no intersection at 
//all, return null. 
//
// For example, the following two linked lists begin to intersect at node c1: 
//
// The test cases are generated such that there are no cycles anywhere in the en
//tire linked structure. 
//
// Note that the linked lists must retain their original structure after the fun
//ction returns. 
//
// Custom Judge: 
//
// The inputs to the judge are given as follows (your program is not given these
// inputs): 
//
// 
// intersectVal - The value of the node where the intersection occurs. This is 0
// if there is no intersected node. 
// listA - The first linked list. 
// listB - The second linked list. 
// skipA - The number of nodes to skip ahead in listA (starting from the head) t
//o get to the intersected node. 
// skipB - The number of nodes to skip ahead in listB (starting from the head) t
//o get to the intersected node. 
// 
//
// The judge will then create the linked structure based on these inputs and pas
//s the two heads, headA and headB to your program. If you correctly return the in
//tersected node, then your solution will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2
//, skipB = 3
//Output: Intersected at '8'
//Explanation: The intersected node's value is 8 (note that this must not be 0 i
//f the two lists intersect).
//From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [
//5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 no
//des before the intersected node in B.
// 
//
// Example 2: 
//
// 
//Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skip
//B = 1
//Output: Intersected at '2'
//Explanation: The intersected node's value is 2 (note that this must not be 0 i
//f the two lists intersect).
//From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [
//3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node bef
//ore the intersected node in B.
// 
//
// Example 3: 
//
// 
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: No intersection
//Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it r
//eads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, whi
//le skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes of listA is in the m. 
// The number of nodes of listB is in the n. 
// 1 <= m, n <= 3 * 104 
// 1 <= Node.val <= 105 
// 0 <= skipA < m 
// 0 <= skipB < n 
// intersectVal is 0 if listA and listB do not intersect. 
// intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect. 
// 
//
// 
//Follow up: Could you write a solution that runs in O(m + n) time and use only 
//O(1) memory? Related Topics Hash Table Linked List Two Pointers 
// 👍 8330 👎 840

import com.lyw.leetCode.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
  * questionId：160
  * question：Intersection of Two Linked Lists
  * date：2022-03-23 17:27:39
*/
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * headA: a1 a2 c1 c2 c3
     * headB: b1 b2 b3 c1 c2 c3
     *
     * a=headA, b=headB
     *
     * a:a1 a2 c1 c2 c3 null b1   b2 b3 c1
     * b:b1 b2 b3 c1 c2 c3   bull a1 a2 c1
     *
     * return: c1 c2 c3
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNodeWithSet(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
