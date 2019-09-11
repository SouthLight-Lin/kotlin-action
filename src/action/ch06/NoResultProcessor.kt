package action.ch06

/**
 * Unit跟Java的不同，Unit可以让一个泛型函数没有返回值
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */
class NoResultProcessor: Processor<Unit> {
    override fun process() {
        // 可以没有返回值
    }

}