package action.ch07._02

import action.ch07.Point

/**
 * 重载比较运算符
 * @author SouthLight-Lin on 2019/9/13
 */
fun main(args: Array<String>) {
    println(Point(10, 20) == Point(10, 20))

    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    println(p1 < p2)

    val p = Point(10, 20)
    println(p[1])

    val multableP = MutablePoint(10, 20)
    multableP[1] = 42
    println(multableP)
}
