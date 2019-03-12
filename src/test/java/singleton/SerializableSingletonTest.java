package singleton;

import com.gp018399.singleton.SerializableSingletion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class SerializableSingletonTest {
    @Test
    void test1(){
        SerializableSingletion s1 = null;
        SerializableSingletion s2 = SerializableSingletion.getInstance();

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("serializableSingletion.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("serializableSingletion.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SerializableSingletion) ois.readObject();

            Assertions.assertEquals(s1,s2,"序列化破坏单例");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
