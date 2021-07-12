package com.huawei.thread;

import com.huawei.utils.NumUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            service.execute(() -> {
                // System.out.println(NumUtil.add10(countDownLatch));
                System.out.println(NumUtil.threadLocalAdd10(countDownLatch));
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count = "+ NumUtil.count);
    }
}
