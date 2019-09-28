package shangshou.jiegou

/**
 * operator将一个函数标记为重载一个操作符或者实现一个约定
 * @author SouthLight-Lin on 2019/9/28
 */
class User(var age: Int, var name: String) {
    operator fun component1() = age
    operator fun component2() = name
}

fun main() {
    val user = User(12, "lnw")
    // 解构
    val (age, name) = user
    println(age)
    println(name)

    // 类似的还有Map 的操作，这种最常用
    val map = mapOf<String, String>("key" to "key", "value" to "value")
    for ((k, v) in map){
        println("$k --- $v")
    }
}