package action.ch07._03

import action.ch07.Point

/**
 * @author SouthLight-Lin on 2019/9/14
 */
data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean{
    // 使用until，表示开区间
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.x until lowerRight.y
}