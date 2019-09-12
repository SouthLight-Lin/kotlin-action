package action.ch07._01

import action.ch07.Point

/**
 * 重载算术运算符operator
 * Created by linnanwei on 2019/9/12
 * @author linnanwei
 */
fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2) // 通过+号调用"plus"方法

    // 也可以扩展不同参数
    val p = Point(10, 20)
    println(p * 1.5)

    // plusAssign函数，+=
    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers[0])

    val list = arrayListOf<Int>(1, 2)
    list += 3
    val newList = list + listOf<Int>(4, 5)
    println(list)
    println(newList)

    // 重载一元运算符
    println(-p)
}