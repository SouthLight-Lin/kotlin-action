package action.ch05

/**
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

fun main(args: Array<String>) {
    val people = listOf<Person>(Person("Alice", 20), Person("Bob", 31))
    // Lambda表达式
    println(people.maxBy { it.age })
    // 也可以这样写，如果Lambda只是委托一个方法或者属性，它可以被一个成员引用代替
    people.maxBy(Person::age)
}

// x: Int, y: Int -> x+y