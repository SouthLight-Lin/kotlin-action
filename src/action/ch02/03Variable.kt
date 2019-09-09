package action.ch02

/**
 * 变量
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
val question = "The\tUltimate\tquestion\tof\tLife,\tthe\tUniverse,\tand\tEverything"
val answer = 42
val answer2: Int = 42
val yearTocompute = 7.5e6  // 7.5*10^6

/**
 * 可变的和不可变的
 * val：（值）不可变的引用，用val声明一个变量不能再初始化后重新复制，对应Java的final
 * var：（变量）可变的引用，它的值是可以改变的
 */

fun main(args: Array<String>) {
    val name = "Kotlin"
    // 使用$字符引用局部变量
    println("Hello, $name")
}