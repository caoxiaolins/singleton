package com.gp018399.singleton.registered;

public enum  EnumSingleton {
    INSTANCE;

    private Object data;

    private EnumSingleton() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
