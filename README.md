## 单例模式

- 饿汉式
- 懒汉式
- 注册式

### 饿汉式

在类加载的时候就会初始化，并创建单例。
```
//静态块
public class HungryStaticSingleton {
    private static final HungryStaticSingleton HUNGRY_STATIC_SINGLETON ;
    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }
    public static HungryStaticSingleton getInstance(){
        return HUNGRY_STATIC_SINGLETON;
    }
}
```
> 优点
- 线程绝对安全，不存在访问安全问题
- 没有加任何锁，执行效率高，比懒汉式用户体验好
> 缺点
- 类加载的时候就初始化，不管用不用都占着空间，浪费空间

### 懒汉式

- 普通懒汉式
- 同步锁懒汉式
- 双重检查同步锁
- 静态内部类

#### 普通懒汉式

- 存在线程安全问题
````
public class LazySimpleSingleton {
    private static LazySimpleSingleton lazySimpleSingleton;

    private void LazySimpleSingleton(){}
    public static LazySimpleSingleton getInstance(){
        if(lazySimpleSingleton == null){
            //为了更好的体现线程安全问题
            Thread.yield();
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
````

#### 同步锁懒汉式

- 存在性能问题
```
public class LazySynchronizedSimpleSingleton {
    private static LazySynchronizedSimpleSingleton lazySimpleSingleton;

    private void LazySimpleSingleton(){}
    public synchronized static LazySynchronizedSimpleSingleton getInstance(){
        if(lazySimpleSingleton == null){
            lazySimpleSingleton = new LazySynchronizedSimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
```

#### 双重校验同步懒汉式
```
public class LazyDoubleCheckSingleton {
    //volatile 禁止指令重排序优化
    private volatile static LazyDoubleCheckSingleton lazySimpleSingleton;

    private void LazySimpleSingleton(){}
    public static LazyDoubleCheckSingleton getInstance(){
        if(lazySimpleSingleton == null){
            synchronized(LazyDoubleCheckSingleton.class){
                if(lazySimpleSingleton == null){
                    lazySimpleSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazySimpleSingleton;
    }
}
```
#### 静态内部类懒汉式

- 没有线程安全问题

```
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
```
1. 使用LazyInnerClassSingleton时，内部类才会加载
2. 不使用时，内部类不会加载

### 注册式

- 枚举
- 容器

#### 枚举

- 不允许被反射
- 饿汉式
- 没有序列化问题

#### 容器

### 破坏单例的行为

- 反射破坏，强制生成新的对象
- 序列化破坏单例