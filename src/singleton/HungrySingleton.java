package singleton;

/**
 * 饿汉模式
 * 缺陷：
 * 类加载时就初始化，浪费内存
 *
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/4
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }

}
