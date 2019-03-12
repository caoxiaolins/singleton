package com.gp018399.singleton.hungry;

/**
 * 饿汉式单例
 */
public class HungrySingleton {
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();
    private HungrySingleton() {
    }
    public static HungrySingleton getInstance(){
        return HUNGRY_SINGLETON;
    }

}
