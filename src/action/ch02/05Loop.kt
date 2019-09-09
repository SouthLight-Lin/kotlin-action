package action.ch02

import java.util.*

/**
 * 循环
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
// 声明到10的数组
val oneToTen = 1..10

fun fizzBuzz(i: Int) = when{
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i"
}

// 使用in检查
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun main(args: Array<String>) {
    for (i in 0 until oneToTen.last)
        println(i)
    for (i in 100 downTo 1 step 2)
        println(fizzBuzz(i))

    // 遍历映射集
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt()) // ASCII转化为二进制
        binaryReps[c] = binary   // 以c为键把数值存在映射集
    }
    for ((letter, binary) in binaryReps){
        println("$letter = $binary")
    }

    println("1111" in "100".."321")
}