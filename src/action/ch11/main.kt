package action.ch11

import java.lang.StringBuilder
import java.time.LocalDate
import java.time.Period

/**
 * 构建结构化的API：DSL中带接受者的lambda
 * Created by linnanwei on 2019/9/23
 * @author linnanwei
 */
// 定义带接受者的函数类型的参数
fun buildString(builderAction: StringBuilder.() -> Unit):String{
    val sb = StringBuilder()
    sb.builderAction()  // 传递一个StringBuilder实例作为lambda的接受者
    return sb.toString()
}

fun main(args: Array<String>) {
    val s = buildString {
        this.append("Hello, ")
        append("World!")
    }
    println(s)

    println(1.days.ago)

    println(1.days.fromNow)
}

val Int.days: Period
    get() = Period.ofDays(this)
val Period.ago: LocalDate
    get() = LocalDate.now() - this
val Period.fromNow: LocalDate
    get() = LocalDate.now() + this