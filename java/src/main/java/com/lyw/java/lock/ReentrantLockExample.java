package com.lyw.java.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private ReentrantLock reentrantLock = new ReentrantLock();

    private void test() {
        reentrantLock.lock();
        System.out.println("进行原子操作");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Thread(reentrantLockExample::test));
        }
    }
}
