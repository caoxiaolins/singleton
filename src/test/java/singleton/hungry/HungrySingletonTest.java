package singleton.hungry;

import com.gp018399.singleton.hungry.HungrySingleton;
import com.gp018399.singleton.hungry.HungryStaticSingleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HungrySingletonTest {
    @Test
    void hungrySingleonTest1(){
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        assertEquals(hungrySingleton1,hungrySingleton2,"不是单例");
    }
    @Test
    void hungryStaticSingletonTest(){
        HungryStaticSingleton hungryStaticSingleton1 = HungryStaticSingleton.getInstance();
        HungryStaticSingleton hungryStaticSingleton2 = HungryStaticSingleton.getInstance();
        assertEquals(hungryStaticSingleton1,hungryStaticSingleton2,"不是单例");
    }
}
