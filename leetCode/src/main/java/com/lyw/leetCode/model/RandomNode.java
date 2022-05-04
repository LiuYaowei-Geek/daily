package com.lyw.leetCode.model;

public class RandomNode {

    public int val;

    public RandomNode next;

    public RandomNode random;

    public RandomNode() {}

    public RandomNode(int val) {
        this.val = val;
    }

    public RandomNode(int val, RandomNode next, RandomNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    @Override
    public String toString() {
        RandomNode cur = this;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append("->").append(random.val).append("||");
            cur = cur.next;
        }
        return sb.delete(sb.length()-2, sb.length()).toString();
    }
}
