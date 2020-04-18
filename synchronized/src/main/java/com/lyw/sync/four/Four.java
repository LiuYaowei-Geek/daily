package com.lyw.sync.four;

/**
 * @author liuyaowei488
 * @date created in 2019-9-27 15:46
 */
public class Four {
    public synchronized void syncMethod() {
        for (int i = 0; i < 888888888; i++) {
        }
    }

    public void syncBlock() {
        synchronized (this) {
            for (int i = 0; i < 888888888; i++) {
            }
        }
    }

    public static void main(String[] args) {
        Four demo = new Four();

        long start, diff;
        start = System.currentTimeMillis();
        demo.syncMethod();
        diff = System.currentTimeMillis() - start;
        System.out.println("syncMethod() :" + diff);

        start = System.currentTimeMillis();
        demo.syncBlock();
        diff = System.currentTimeMillis() - start;
        System.out.println("syncBlock() :" + diff);
    }
}
