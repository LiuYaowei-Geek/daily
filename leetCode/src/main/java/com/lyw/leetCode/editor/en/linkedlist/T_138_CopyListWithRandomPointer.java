//A linked list of length n is given such that each node contains an additional 
//random pointer, which could point to any node in the list, or null. 
//
// Construct a deep copy of the list. The deep copy should consist of exactly n 
//brand new nodes, where each new node has its value set to the value of its corre
//sponding original node. Both the next and random pointer of the new nodes should
// point to new nodes in the copied list such that the pointers in the original li
//st and copied list represent the same list state. None of the pointers in the ne
//w list should point to nodes in the original list. 
//
// For example, if there are two nodes X and Y in the original list, where X.ran
//dom --> Y, then for the corresponding two nodes x and y in the copied list, x.ra
//ndom --> y. 
//
// Return the head of the copied linked list. 
//
// The linked list is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where: 
//
// 
// val: an integer representing Node.val 
// random_index: the index of the node (range from 0 to n-1) that the random poi
//nter points to, or null if it does not point to any node. 
// 
//
// Your code will only be given the head of the original linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// Example 2: 
//
// 
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
// 
//
// Example 3: 
//
// 
//
// 
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 1000 
// -104 <= Node.val <= 104 
// Node.random is null or is pointing to some node in the linked list. 
// 
// Related Topics Hash Table Linked List 
// 👍 8825 👎 997


package com.lyw.leetCode.editor.en.linkedlist;

import com.lyw.leetCode.model.RandomNode;

import java.util.HashMap;

//Java：T_138_Copy List with Random Pointer
public class T_138_CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new T_138_CopyListWithRandomPointer().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        /**
         * 时间复杂度O(n)，空间复杂度O(n)
         * 使用hashmap
         * 1. 遍历链表，key为当前节点，value为根据当前节点val新建的节点
         * 2. 再次遍历链表，为map中value节点的next和random赋值
         */
        private RandomNode copyListWithRandomUseHash(RandomNode head) {
            //使用map保存原链表和复制链表
            //（1，1'）（2，2'）...
            HashMap<RandomNode, RandomNode> map = new HashMap<>();
            //保持head节点位置不变（内存地址不变），使用cur来遍历链表
            RandomNode cur = head;

            while (cur != null) {
                //map保持node和node'，node为原节点，node'为val相等的复制节点
                map.put(cur, new RandomNode(cur.val));
                cur = cur.next;
            }
            //cur重新指向头节点，重新遍历链表
            cur = head;
            while (cur != null) {
                //为node'的next和random赋值
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            //返回复制的链表
            return map.get(head);
        }

        /**
         * 时间复杂度O(n)，空间复杂度O(1)
         * 1. 遍历链表，将复杂节点链接到当前节点后，1->1'->2->2'....
         * 2. 遍历链表，为克隆节点的random赋值，1->1'->2->2'....
         * 3. 遍历链表，断开节点与克隆节点的链接，并为克隆节点的next赋值，1->2.....; 1'->2'....
         */
        private RandomNode copyListWithRandom(RandomNode head) {
            if (head == null) {
                return null;
            }

            RandomNode cur = head;
            RandomNode next = null;

            //克隆当前节点到当前节点的Next位置
            //1->1'->2->2'.....
            while (cur != null) {
                //记录next节点
                next = cur.next;
                //新建cur'节点，并指向cur.next
                cur.next = new RandomNode(cur.val);
                //将next节点执向cur'
                cur.next.next = next;
                //cur指向next，继续遍历链表
                cur = next;
            }

            //重新指向head，再次遍历链表
            cur = head;
            //cur节点的克隆节点
            RandomNode curCopy = null;

            while (cur != null) {
                //记录原链表中的next节点
                next = cur.next.next;
                //curCopy为cur节点的克隆节点
                curCopy = cur.next;
                //curCopy.random为cur.random的复制节点，即cur.random.next
                curCopy.random = cur.random != null ? cur.random.next : null;
                //指向原链表中的next节点，继续遍历链表
                cur = next;
            }

            //重新指向head，再次遍历链表
            cur = head;
            //复制的链表
            RandomNode headCopy = head.next;
            while (cur != null) {
                ////记录原链表中的next节点
                next = cur.next.next;
                //curCopy为cur节点的克隆节点
                curCopy = cur.next;
                //断开节点与克隆节点，还原原链表结构
                cur.next = next;
                //curCopy.next为cur.next的复制节点，即cur.next.next.next
                curCopy.next = next != null ? next.next : null;
                //指向原链表中的next节点，继续遍历链表
                cur = next;
            }
            return headCopy;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}