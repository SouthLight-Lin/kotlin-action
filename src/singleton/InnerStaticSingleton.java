package singleton;

/**
 * 静态内部类
 * 描述：懒加载，线程安全，实现难度简单
 * 原理：利用了ClassLoader机制来保证初始化instance时只有一个线程。
 * 只有调用静态方法getInstance方法时，才会显式装载SingletonHolder类
 * 从而实例化instance
 *
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/6
 */
public class InnerStaticSingleton {

    private static class SingletonHolder {
        private static final InnerStaticSingleton INSTANCE
                = new InnerStaticSingleton();
    }

    private InnerStaticSingleton() {}

    public static final InnerStaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
