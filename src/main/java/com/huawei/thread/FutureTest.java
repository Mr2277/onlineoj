package com.huawei.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 等凉菜
        Callable ca1 = new Callable(){

            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();
        System.out.println(ft1.get());

    }
}
