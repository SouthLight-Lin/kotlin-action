package action.ch09._02

import java.lang.IllegalArgumentException

/**
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */

fun printSum(c: Collection<*>){
    val intList = c as? List<Int>
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun main(args: Array<String>) {
    printSum(listOf(1,2,3))
    printSum(setOf(1,2,3))
    println(listOf("1", "2", "3"))
}