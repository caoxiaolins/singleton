package com.gp018399.singleton.lazy;

/**
 * 懒汉式
 * 静态内部类
 *
 */
public class LazyInnerClassSingleton {

    private void LazyInnerClassSingleton() throws Exception {
        if(InnerClass.INSTANCE != null){
            throw new Exception("不允许创建多个实例");
        }
    }
    //static 使用单例空间共享
    //final 防止类被重写
    public static final LazyInnerClassSingleton getInstance(){
        return InnerClass.INSTANCE;
    }

    private static class InnerClass{
        private static final LazyInnerClassSingleton INSTANCE = new LazyInnerClassSingleton();
    }
}
