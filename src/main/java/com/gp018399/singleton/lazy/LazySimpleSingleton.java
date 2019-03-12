package com.gp018399.singleton.lazy;

/**
 * 懒汉式
 */
public class LazySimpleSingleton {
    private static LazySimpleSingleton lazySimpleSingleton;

    private void LazySimpleSingleton(){}
    public static LazySimpleSingleton getInstance(){
        if(lazySimpleSingleton == null){
            //为了更好的体现线程安全问题
            Thread.yield();
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
