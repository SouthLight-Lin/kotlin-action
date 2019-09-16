package action.ch07._03

import action.ch07.Point
import java.time.LocalDate

/**
 * @author SouthLight-Lin on 2019/9/14
 */

fun main(args: Array<String>) {
    val rect = Rectangle(Point(10, 20), Point(50, 50))
    // in右边的对象将会调用contains函数，左边的对象将会作为入参
    println(Point(20, 30) in  rect)
    println(Point(5, 5) in rect)

    /** rangeTo **/
    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)   // 创建一个从今天开始的10天时间
    println(now.plusWeeks(1) in vacation) // true

}