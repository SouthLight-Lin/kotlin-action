package action.ch05._02

import action.ch05.Person

/**
 * Lambda操作集合
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

fun main(args: Array<String>) {
    /** filter从集合中移除不想要的元素，但是不能修改元素 **/
    val list = listOf(1,2,3,4)
    println(list.filter { it % 2 == 0 })
    val people = arrayListOf(Person("Alice", 20), Person("Bob", 31))
    println(people.filter { it.age > 30 })

    /** map函数可以修改元素，对集合中的每个元素应用给定的函数 **/
    val list2 = listOf(1,2,3,4)
    println(list2.map { it * it })
    // 打印名字
    println(people.map(Person::name))
    println(people.filter { it.age > 30 }.map(Person::name))

    // 对映射应用也可过滤
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })

    /** all,any,count,find：对集合应用预言，也就是检查集合中的元素是否都满足某个条件 **/
    println(people.all(canBeInClub27)) // false
    println(people.any(canBeInClub27)) // true
    println(people.count(canBeInClub27)) // 1
    println(people.find(canBeInClub27)) // Alice

    /** groupBy：把列表转换为多组映射 **/
    people.add(Person("Carol", 31))
    println(people.groupBy(Person::age))

    /** flatMap和flatten：处理嵌套集合中的元素 **/
    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    /** 将集合转化为序列，在遍历的时候回更加高效，你把它想象成Stream吧 **/
    people.asSequence()            // 1 把初始化集合转化为序列
        .map(Person::name)         // 2 序列支持跟集合同样的API
        .filter { it.startsWith("A") }
        .toList()                  // 3 把结果序列转化为列表


    println(listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }.toList())
    // 使用序列，是惰性求值，它是一个一个的求值，再调用find
    // 而使用列表，是提前计算，也就是讲所有的值求出来，再调用find
    println(listOf(1, 2, 3, 4).asSequence()
        .map { it * it }.find { it > 3 })
}

/** 检查某个人是否小于等于27岁 **/
val canBeInClub27 = {p: Person -> p.age<=27}