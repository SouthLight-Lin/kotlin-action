package action.ch09

/**
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */
// 自动推导泛型
val <T> List<T>.penultimate: T
    get() = this[size-2]

fun main(args: Array<String>) {
    println(listOf(1,2,3,4).penultimate)
}