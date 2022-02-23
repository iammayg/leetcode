package test;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-23
 */
public class Singleton {
    private volatile static Singleton singleton;//volatile防止指令重排。未创建对象导致其他线程读取错误

    private Singleton() {

    }

    public Singleton getSingleton() {
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
