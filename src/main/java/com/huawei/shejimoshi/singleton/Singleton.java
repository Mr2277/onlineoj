package com.huawei.shejimoshi.singleton;

import java.util.HashSet;
import java.util.Set;

public class Singleton {
    /*
    private Singleton() {

    }

    public static Singleton singleton;

    static {
        singleton = new Singleton();
    }

    public static Singleton getSingleton() {
        return singleton;
    }
    */

    public static volatile Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
              //  if (singleton == null) {
                    singleton = new Singleton();
                //}
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> set.add(Singleton.getSingleton().toString())).start();
            /*
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
        */
        }
        System.out.println(set.size());
    }
}
