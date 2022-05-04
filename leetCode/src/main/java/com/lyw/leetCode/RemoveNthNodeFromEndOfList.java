package com.lyw.leetCode;

import com.lyw.leetCode.model.ListNode;

import java.util.Stack;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head != null) {
            stack1.push(head.val);
            head = head.next;
        }
        int i = 1;
        while (i != n) {
            stack2.push(stack1.pop());
            i++;
        }
        stack1.pop();
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        ListNode temp = new ListNode();
        ListNode res = new ListNode(stack2.pop(), temp);
        while (!stack2.empty()) {
            temp = new ListNode(stack2.pop(), new ListNode());
            temp.next = temp;
        }
        return res;
    }
}
