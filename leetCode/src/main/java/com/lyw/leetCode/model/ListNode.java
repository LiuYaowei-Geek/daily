package com.lyw.leetCode.model;


public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    //@Override
    //public String toString() {
    //    StringBuilder sb = new StringBuilder();
    //    sb.append(val).append(" ");
    //    while (next != null) {
    //        sb.append(next.val).append(" ");
    //        next = next.next;
    //    }
    //    return sb.toString();
    //}
}
