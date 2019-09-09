package action.ch02

/**
 * 函数
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
/**
 * 返回类型写在参数列表的后面
 */
fun max(a: Int, b: Int): Int{
    return if (a>b) a else b
}

/**
 * 简化上面的max函数，如果只有一条代码，就可直接这样写
 * 这行代码叫做表达式主体
 */
fun max2(a: Int, b: Int): Int = if (a>b) a else b

fun main(args: Array<String>) {
    println(max(1, 2))
    println(max2(1, 2))
}