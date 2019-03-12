package com.gp018399.singleton.lazy;

/**
 * 懒汉式
 */
public class LazySimpleSingleton {
    private static LazySimpleSingleton lazySimpleSingleton;

    private void LazySimpleSingleton(){}
    private static LazySimpleSingleton getInstance(){
        if(lazySimpleSingleton == null){
            return new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
