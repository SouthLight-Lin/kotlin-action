package action.ch09._01

import java.lang.Appendable

/**
 * 找出两个条目中最大值的泛型函数
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */
fun <T: Comparable<T>> max(first: T, second: T): T{
    return if (first>second) first else second
}

/** 为一个类型参数指定多个约束 **/
fun <T> ensureTrailingPeriod(seq: T)
    where T: CharSequence, T: Appendable{  //类型参数约束的列表
    if (!seq.endsWith('.')){
        seq.append('.')
    }
}

fun main() {
    println(max("kotlin", "java"))
}