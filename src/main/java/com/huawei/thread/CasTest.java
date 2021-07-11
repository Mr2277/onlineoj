package com.huawei.thread;

public class CasTest {

    public static Integer count = 0;

    public static Integer count1 = 0;

    public Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        CasTest casTest = new CasTest();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    count++;
                }
            }).start();
        }
        System.out.println(count);

        for (int j = 0; j < 10000; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                   synchronized (casTest.lock) {
                       count1++;
                   }
                }
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(count1);


    }

}
