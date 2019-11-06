package singleton;

/**
 * 懒汉模式，线程安全
 * 缺陷：
 * 每次操作必须加锁synchronized才能保证安全，影响效率
 *
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/6
 */
public class SafeLazySingleton {

    private static SafeLazySingleton instance;

    private SafeLazySingleton() {}

    public static synchronized SafeLazySingleton getInstance() {
        if (instance == null) {
            instance = new SafeLazySingleton();
        }
        return instance;
    }

}
