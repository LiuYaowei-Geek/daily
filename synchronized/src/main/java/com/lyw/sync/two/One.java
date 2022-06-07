package com.lyw.sync.two;

/**
 * @author liuyaowei488
 * @date created in 2019-9-27 10:48
 */
public class One {
    //同步代码块
    public void syncMethod() {
        synchronized (this) {
            System.out.println(this.getClass().getName());
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " syncMethod loop " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //非同步代码块
    public void nonSyncMethod() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " syncMethod loop " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final One one = new One();
        //同步方法
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        one.syncMethod();
                    }
                }, "thread1"
        );

        //异步方法
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        one.nonSyncMethod();
                    }
                }, "thread2"
        );

        t1.start();
        t2.start();
    }
}
