package singleton.lazy;

import com.gp018399.singleton.ExecutorThread;
import com.gp018399.singleton.lazy.LazySimpleSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
