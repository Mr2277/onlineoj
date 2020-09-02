package com.huawei.test;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    private static Integer count = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void increMethod() {
        count ++;
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    lock.lock();
                    increMethod();
                }
            }).start();

        }
        Thread.sleep(2000);
        System.out.println(count);
    }
}
