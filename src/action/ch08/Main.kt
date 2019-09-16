package action.ch08

/**
 * @author SouthLight-Lin on 2019/9/16
 */
// 定义一个函数类型的参数
fun twoAndThree(operation : (Int, Int) -> Int){
    val res = operation(2,3)
    println("The result is $res")
}

/** predicate的命名随意 **/
fun String.filter(predicate: (Char) -> Boolean):String{
    val sb = StringBuilder()
    for (index in 0 until length){
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

/** 使用函数类型的可空参数 **/
fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "",
        transform: ((T) -> String)? = null   // 声明一个函数类型的可空参数
): String{
    val res = StringBuilder(prefix)
    for((index, element) in this.withIndex()){
        if (index > 0)  res.append(separator)
        val str = transform?.invoke(element)
                ?:element.toString()
        res.append(str
        )
    }
    res.append(postfix)
    return res.toString()
}



fun main(args: Array<String>) {
    twoAndThree{ a, b -> a+b}
    twoAndThree{ a, b -> a*b}
    println("ab1c".filter { it in 'a'..'z' })
}

