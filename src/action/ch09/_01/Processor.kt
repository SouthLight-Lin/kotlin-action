package action.ch09._01

import java.lang.IllegalArgumentException

/**
 * <T: Any>确保了类型T永远都是非空类型
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */
class Processor<T: Any> {
    fun process(value: T){
        value.hashCode()
    }
}

fun printSum(c: Collection<*>){
    val intList = c as? List<Int>
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun main(args: Array<String>) {
    val nullableStringProcessor = Processor<String>()
    nullableStringProcessor.process("a")
    printSum(listOf(1,2,3))
    printSum(setOf(1,2,3))
    println(listOf("1", "2", "3"))
}