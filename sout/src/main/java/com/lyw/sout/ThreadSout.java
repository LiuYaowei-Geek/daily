package com.lyw.sout;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuyaowei488
 * @date created in 2019-9-29 14:05
 */
public class ThreadSout extends Thread {


    @Override
    public void run() {
        System.out.println("run" + ": " + new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + ": " + Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
    }


    public static void main(String[] args) {
        ThreadSout thread = new ThreadSout();
        System.out.println("new" + ": " + new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + ": " + thread.getName() + ": " + thread.getState());
        thread.start();
        System.out.println("runnable" + ": " + new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + ": " + thread.getName() + ": " + thread.getState());
        try {
            System.out.println("sleeping start" + ": " + new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + ": " + thread.getName() + ": " + thread.getState());
            Thread.sleep(1000);
            System.out.println("sleeping end" + ": " + new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + ": " + thread.getName() + ": " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + ": " + Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
    }
}
