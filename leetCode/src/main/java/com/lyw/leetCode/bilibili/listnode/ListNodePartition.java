package com.lyw.leetCode.bilibili.listnode;

import com.lyw.leetCode.model.ListNode;

public class ListNodePartition {
    public static void main(String[] args) {

    }

    /**
     * 按照pivot拆分head链表为小于区域-》等于区域-》大于区域
     * @param head
     * @param pivot
     * @return
     */
    private static ListNode listNodePartition(ListNode head, int pivot) {
        ListNode smallHead = null;
        ListNode smallTail = null;

        ListNode equalHead = null;
        ListNode equalTail = null;

        ListNode bigHead = null;
        ListNode bigTail = null;

        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;

            if (head.val < pivot) {
                if (smallHead == null) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = head;
                }
            }

            if (head.val == pivot) {
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            }

            if (head.val > pivot) {
                if (bigHead == null) {
                    bigHead = head;
                    bigTail = head;
                } else {
                    bigTail.next = head;
                    bigTail = head;
                }
            }
            head = next;
        }
        //有小于区域
        if (smallTail != null) {
            smallTail.next = equalHead;
            //下一步，谁去连大于区域的头，谁就变成et
            equalTail = equalTail == null ? smallTail : equalTail;
        }
        //如果小于区域和等于区域，不是都没有
        if (equalTail != null) {
            equalTail.next = bigHead;
        }
        //返回小于区域->等于区域->大于区域
        return smallHead != null ? smallHead : (equalHead != null ? equalHead : bigHead);
    }
}
