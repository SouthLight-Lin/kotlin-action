package action.ch03

import action.ch03.strings.joinToString

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */

fun main(args: Array<String>) {
    val list = arrayListOf(1,2,3)
    println(list.javaClass)
    println(list)
    println(list.joinToString(separator = ";", prefix = "(", postfix = ")"))
    // 因该函数设置了默认赋值功能，所以不需要重载方法
    println(list.joinToString())
    println(list.joinToString( ";"))
    println(list.joinToString( postfix = "#"))
}
