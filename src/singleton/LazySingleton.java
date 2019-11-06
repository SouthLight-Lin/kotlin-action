package singleton;

/**
 * 懒汉模式，线程不安全
 * 缺陷：
 * 多线程环境下不能保证正确
 *
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/4
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
