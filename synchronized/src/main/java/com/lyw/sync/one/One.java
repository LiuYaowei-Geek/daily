package com.lyw.sync.one;

/**
 * @author liuyaowei488
 * @date created in 2019-9-26 17:31
 */
public class One implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
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
        Runnable demo = new One();

        Thread t1 = new Thread(demo, "t1");
        Thread t2 = new Thread(demo, "t2");

        t1.start();
        t2.start();
    }

}
