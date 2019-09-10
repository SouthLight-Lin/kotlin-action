package action.ch03

/**
 * 创建集合
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */

val set = setOf(1,7,53)
val list = listOf(1,7,53)
val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
fun main(args: Array<String>) {
    println(set.javaClass)  // LinkedHashSet
    println(list.javaClass)  // ArrayList
    println(map.javaClass)   // LinkedHashMap
    val strings = listOf("first", "second", "fourteenth")
    // 获取最后一个元素
    println(strings.last())
    val numbers = setOf(1,14,2)
    // 获取最大值
    println(numbers.max())
}
