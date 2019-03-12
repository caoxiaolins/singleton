package com.gp018399.singleton;

import java.io.Serializable;

public class SerializableSingletion implements Serializable {
    private static final SerializableSingletion INSTANCE = new SerializableSingletion();

    private void SerializableSingletion(){}

    public static final SerializableSingletion getInstance(){
        return INSTANCE;
    }

    public Object readResolve(){
        return INSTANCE;
    }
}
