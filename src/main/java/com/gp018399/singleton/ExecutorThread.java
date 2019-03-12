package com.gp018399.singleton;

import com.gp018399.singleton.lazy.LazySynchronizedSimpleSingleton;

public class ExecutorThread implements Runnable {
    public void run() {
        LazySynchronizedSimpleSingleton lazySimpleSingleton = LazySynchronizedSimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+lazySimpleSingleton);
    }
}
