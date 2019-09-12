package action.ch07._01

import action.ch07.Point

/**
 * 重載二元算术运算
 * Created by linnanwei on 2019/9/12
 * @author linnanwei
 */
/**一般都是将运算符定义成扩展函数**/
operator fun Point.plus(other: Point): Point {
    return Point(x+other.x, y+other.y)
}

/** 定义一个运算数类型不同的运算符 **/
operator fun Point.times(scale: Double): Point{
    return Point((x*scale).toInt(), (y*scale).toInt())
}

/** 重载一元运算符 **/
operator fun Point.unaryMinus(): Point{
    return Point(-x, -y)
}
operator fun Point.unaryPlus(): Point{
    return Point(+x, +y)
}