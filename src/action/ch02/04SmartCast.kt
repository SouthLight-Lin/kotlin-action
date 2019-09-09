package action.ch02

import java.lang.IllegalArgumentException

/**
 * 只能类型转换
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
/** 提供不同种类表达式的公用类型接口记号 **/
interface Expr
/** 叶子节点 **/
class Num(val value:Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

/** 计算表达式 **/
fun eval(e: Expr): Int{
    if (e is Num){
        // 如果判断正确，编译器会自动帮你转成Num类型
        return e.value
    }
    if (e is Sum){
        // 如果判断正确，编译器会自动帮你转成Sum类型
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun evalWithLogging(e: Expr): Int =
    when(e) {
        is Num -> {
            println("num: ${e.value}")
            e.value       // 代码块的最后一个表达式，如果e是Num类型，它将被返回
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")

            left+right  // 代码块的最后一个表达式，如果e是Sum类型，它将被返回
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main(args: Array<String>) {
    println(evalWithLogging((Sum(Sum(Num(1), Num(2)), Num(4)))))
}