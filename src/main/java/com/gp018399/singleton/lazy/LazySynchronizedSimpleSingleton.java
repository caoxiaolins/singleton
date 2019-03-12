package com.gp018399.singleton.lazy;

/**
 * 懒汉式
 */
public class LazySynchronizedSimpleSingleton {
    private static LazySynchronizedSimpleSingleton lazySimpleSingleton;

    private void LazySimpleSingleton(){}
    public synchronized static LazySynchronizedSimpleSingleton getInstance(){
        if(lazySimpleSingleton == null){
            lazySimpleSingleton = new LazySynchronizedSimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
