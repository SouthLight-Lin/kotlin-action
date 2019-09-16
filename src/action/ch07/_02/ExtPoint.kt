package action.ch07._02

import action.ch07.Point
import java.lang.IndexOutOfBoundsException

/**
 * 扩展集合的get和 set
 * @author SouthLight-Lin on 2019/9/13
 */
operator fun Point.get(index: Int): Int{
    return when(index){
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int){
    when(index){
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}