package action.ch01

/**
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */

// 数据类，age可为空
data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf<Person>(Person("Alice"),
        Person("Bob", age = 29)
    )
    // 如果age为null则返回0
    val oldest = persons.maxBy {  it.age ?:0 }
    println("The oldest is: $oldest")
}