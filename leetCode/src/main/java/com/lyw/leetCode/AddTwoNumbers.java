package com.lyw.leetCode;


import com.lyw.leetCode.model.ListNode;

public class AddTwoNumbers {

//    private ListNode solution(ListNode l1, ListNode l2) {
//        ListNode res = new ListNode(0);
//        ListNode resNext = new ListNode(0);
//        int carry = 0;
//        while (null != l1 || null != l2) {
//            int value1 = null != l1 ? l1.val : 0;
//            int value2 = null != l2 ? l2.val : 0;
//            int sum = carry + value1 + value2;
//            carry = sum / 10;
//            res.val = sum % 10;
//            res.next = new ListNode(0);
//            res = res.next;
//            l1 = l1 != null ? l1.next : null;
//            l2 = l2 != null ? l2.next : null;
//        }
//        if (carry == 1) {
//
//        }
//        return res;
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(l1, l2);
    }
}
