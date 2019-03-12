package com.gp018399.singleton.lazy;

/**
 * 懒汉式
 * 双重检查
 */
public class LazyDoubleCheckSingleton {
    //volatile 禁止指令重排序优化
    private volatile static LazyDoubleCheckSingleton lazySimpleSingleton;

    private void LazySimpleSingleton(){}
    public static LazyDoubleCheckSingleton getInstance(){
        if(lazySimpleSingleton == null){
            synchronized(LazyDoubleCheckSingleton.class){
                if(lazySimpleSingleton == null){
                    lazySimpleSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazySimpleSingleton;
    }
}
