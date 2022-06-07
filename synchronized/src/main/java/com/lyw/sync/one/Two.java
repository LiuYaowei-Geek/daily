package com.lyw.sync.one;

/**
 * @author liuyaowei488
 * @date created in 2019-9-27 10:22
 */
public class Two extends Thread {
    public Two(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Thread t1 = new Two("t1");
        Thread t2 = new Two("t2");
        t1.start();
        t2.start();
    }
}
