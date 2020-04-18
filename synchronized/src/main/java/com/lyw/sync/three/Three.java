package com.lyw.sync.three;

/**
 * @author liuyaowei488
 * @date created in 2019-9-27 15:25
 */
public class Three {
    //同步代码块
    public void syncMethod1() {
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
    public void syncMethod2() {
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

    public static void main(String[] args) {
        final Three one = new Three();
        //同步方法
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        one.syncMethod1();
                    }
                }, "thread1"
        );

        //异步方法
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        one.syncMethod2();
                    }
                }, "thread2"
        );

        t1.start();
        t2.start();
    }
}
