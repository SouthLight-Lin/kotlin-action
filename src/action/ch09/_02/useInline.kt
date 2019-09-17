package action.ch09._02

import java.util.*

/**
 * 使用内联函数完成参数类型校验
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */
// reified声明类型参数不会在运行时擦除
inline fun <reified T> isA(value: Any) = value is T

inline fun <reified T> loadService(): ServiceLoader<T>? {
    return ServiceLoader.load(T::class.java)
}

fun main(args: Array<String>) {
    println(isA<String>("a"))
    println(isA<Int>("a"))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())
}