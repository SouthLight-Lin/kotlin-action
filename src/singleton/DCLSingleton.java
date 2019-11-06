package singleton;

/**
 * 双重校验锁单例
 * 描述：懒加载，线程安全，但是实现难度复杂，代码复杂，
 * 但是在多线程情况下保持高性能
 *
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/6
 */
public class DCLSingleton {

    private volatile static DCLSingleton singleton;

    private DCLSingleton() {}

    public static DCLSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DCLSingleton.class) {
                if (singleton == null) {
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }

}
