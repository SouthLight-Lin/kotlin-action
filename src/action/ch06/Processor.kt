package action.ch06

/**
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */
interface Processor<T> {
    fun process(): T
}