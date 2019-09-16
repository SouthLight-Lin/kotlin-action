package action.ch07._04

import action.ch07.Point
import java.time.LocalDate

/**
 * @author SouthLight-Lin on 2019/9/14
 */
fun main(args: Array<String>) {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff){
        println(dayOff)
    }

    val p = Point(10, 20)
    val (x, y)  = p
    println(x)
    println(y)
}