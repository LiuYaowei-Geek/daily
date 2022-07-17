package com.lyw.leetCode.hot100;
//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1. 
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 104 
// 0 <= value <= 105 
// At most 2 * 105 calls will be made to get and put. 
// 
// Related Topics Hash Table Linked List Design Doubly-Linked List 
// 👍 12485 👎 486

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * questionId：146
 * question：LRU Cache
 * date：2022-03-21 22:45:53
 */
public class LruCache {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 1.使用链表，每个节点记录pre和next节点。
     * 2.使用head和tail记录LRUCache的头和尾，head和tail都是空节点，作为标识位，因为超出缓存容量时要删除最后一个节点。初始化时头尾相连
     * 3. LRU.get()时，先删除对应节点，再插入节点
     * 4. LRU.put()时，cache中存在时，先删除节点再插入节点。cache中不存在时，没到最大容量时直接插入，到最大容量时，先删除再插入
     * 5. 缓存插入节点时，节点始终保持在head后，因此需要修改head.next、head.next.pre、cur.pre、cur.next
     * 6. 缓存删除节点时，需要修改cur.pre.next和cur.next.pre；
     */
    class LRUCache {

        class Node {
            Node prev, next;
            int key, value;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        //固定的头结点
        Node head = new Node(0, 0);
        //固定的尾结点
        Node tail = new Node(0, 0);
        //缓存实现
        Map<Integer, Node> map = new HashMap<>();
        //容量
        int CAPACITY;

        public LRUCache(int capacity) {
            //初始化
            CAPACITY = capacity;
            //头尾相连
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                //先删除再插入，保证node排在最前面(head后面)
                remove(node);
                insert(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            //存在时，先删除
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            //达到最大容量时，删除最后一个节点(tail前一个节点)
            if (map.size() == CAPACITY) {
                remove(tail.prev);
            }
            //插入
            insert(new Node(key, value));
        }

        //删除节点，需要修改node前后的节点
        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        //插入节点，需要修改node前后包含node节点的prev和next值
        private void insert(Node node) {
            map.put(node.key, node);
            Node headNext = head.next;
            head.next = node;
            node.prev = head;
            headNext.prev = node;
            node.next = headNext;
        }

    }

    class LRUCacheWithLinkedHashMap {

        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;

        public LRUCacheWithLinkedHashMap(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

} 
