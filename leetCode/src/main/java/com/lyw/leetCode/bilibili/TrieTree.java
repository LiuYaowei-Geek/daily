package com.lyw.leetCode.bilibili;


/**
 * 前缀树/字典树
 */
public class TrieTree {

    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;
        public TrieNode() {
            pass = 0;
            end = 0;
            //nexts[0] == null 代表没有走向a的路
            //nexts[0] != null 有走向a的路
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            //从左往右遍历字符
            for (int i = 0; i < chs.length; i++) {
                //由字符，对应走向哪条路
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        //所有加入的字符中，有几个是以pre开头的
        public int prefixNum(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        public  void delete(String word) {
            if (search(word) == 0) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            int index = 0;
            for (char c : chs) {
                index = c - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }
}
