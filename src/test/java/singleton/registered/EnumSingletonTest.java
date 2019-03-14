package singleton.registered;

import com.gp018399.singleton.registered.EnumSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class EnumSingletonTest {
    @Test
    void test1(){
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        enumSingleton.setData(new Object());
        System.out.println(enumSingleton.getData());
    }
    @Test
    void test2(){
        EnumSingleton s1 = null;
        EnumSingleton s2 = EnumSingleton.getInstance();
        s2.setData(new Object());
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("serializableSingletion.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("serializableSingletion.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (EnumSingleton) ois.readObject();

            Assertions.assertEquals(s1.getData(),s2.getData(),"序列化破坏单例");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void test3(){
        try {
            Class<?> clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            c.newInstance(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
