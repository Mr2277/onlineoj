package com.huawei.utils;

import java.util.concurrent.CountDownLatch;

public class NumUtil {

    public static Integer count = 0;

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public synchronized static Integer add10(CountDownLatch countDownLatch) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        countDownLatch.countDown();
        return count;
    }

    public static Integer threadLocalAdd10(CountDownLatch countDownLatch) {
        threadLocal.set(count);
        countDownLatch.countDown();
        return threadLocal.get() + 10;
    }

}
