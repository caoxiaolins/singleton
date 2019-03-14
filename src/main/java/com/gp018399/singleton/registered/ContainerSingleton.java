package com.gp018399.singleton.registered;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
    private void ContainerSingleton(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String beanName){

        synchronized (ioc){
            if(!ioc.containsKey(beanName)){
                try {
                    Class<?> clazz =  Class.forName(beanName);
                    Object object = clazz.newInstance();
                    ioc.put(beanName,object);
                    return object;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return ioc.get(beanName);
        }
    }
}
