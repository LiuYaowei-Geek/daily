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
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int carry = 0;
        while (null != l1 || null != l2) {
            int value1 = null != l1 ? l1.val : 0;
            int value2 = null != l2 ? l2.val : 0;
            int sum = carry + value1 + value2;
            temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp = temp.next;
            l1 = null != l1 ? l1.next : null;
            l2 = null != l2 ? l2.next : null;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
//        System.out.println(res);
    }
}
