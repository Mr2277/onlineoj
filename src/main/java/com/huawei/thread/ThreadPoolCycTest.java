package com.huawei.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolCycTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(9);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(9);
        for (int i = 0; i < 9; i++) {
            executor.execute(() -> {
                try {
                    cyclicBarrier.await();
                    System.out.println("收集龙珠" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("end" + System.currentTimeMillis());
    }
}
