package com.huawei.thread;


import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        //System.out.println(end - start);
    }
}
