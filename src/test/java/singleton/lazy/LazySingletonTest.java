package singleton.lazy;

import com.gp018399.singleton.ExecutorThread;
import com.gp018399.singleton.lazy.LazyInnerClassSingleton;
import com.gp018399.singleton.lazy.LazySimpleSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class LazySingletonTest {
    @Test
    void LazySimpleSingletonTest(){
        LazySimpleSingleton lazySimpleSingleton1 = LazySimpleSingleton.getInstance();
        LazySimpleSingleton lazySimpleSingleton2 = LazySimpleSingleton.getInstance();
        Assertions.assertEquals(lazySimpleSingleton1,lazySimpleSingleton2,"不是单例！");

    }
    @Test
    void LazySimpleSingletonTest2(){
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());
        t1.start();
        t2.start();
    }

    @Test
    void LazySimpleSingletonTest3(){
        try {
            //反射破坏单例
            Class<?> clazz = LazyInnerClassSingleton.class;
            //获取构造器  不管是不是私有的
            Constructor c = clazz.getConstructor(null);
            c.setAccessible(true);

            Object o1 = c.newInstance(null);
            Object o2 = c.newInstance(null);
            Assertions.assertEquals(o1,o2,"不是单例，被反射破坏");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
