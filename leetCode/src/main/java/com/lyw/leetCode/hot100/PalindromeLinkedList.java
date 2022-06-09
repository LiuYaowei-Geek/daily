package com.lyw.leetCode.hot100;
//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 105]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 
// 👍 8356 👎 514

import com.lyw.leetCode.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
  * questionId：234
  * question：Palindrome Linked List
  * date：2022-03-27 15:41:24
*/
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = p1.next;
        ListNode pre = p1;
        //find mid pointer, and reverse head half part
        while (p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        //odd number of elements, need left move p1 one step
        if (p2.next == null) {
            p1 = p1.next;
        } else {   //even number of elements, do nothing

        }
        //compare from mid to head/tail
        while (p3 != null) {
            if (p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;
    }


    public boolean isPalindrome1(ListNode head) {
        if (null == head) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size()/2 + 1; i++) {
            if ((list.get(i) ^ list.get(list.size() - i - 1)) != 0) {
                return false;
            }
            //if (!list.get(i).equals(list.get(list.size() - i - 1))) {
            //    return false;
            //}
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
