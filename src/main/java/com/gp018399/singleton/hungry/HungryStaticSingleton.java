package com.gp018399.singleton.hungry;

/**
 * 饿汉式
 * 静态块
 */
public class HungryStaticSingleton {
    private static final HungryStaticSingleton HUNGRY_STATIC_SINGLETON ;
    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }
    public static HungryStaticSingleton getInstance(){
        return HUNGRY_STATIC_SINGLETON;
    }
}
