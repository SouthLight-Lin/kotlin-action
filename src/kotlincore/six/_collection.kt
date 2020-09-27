package kotlincore.six

/**
 * 集合
 * @author linnanwei
 * @since 1.0.0
 */

fun readOnlyList() {
    val list = listOf(1, 2, 3, 4, 5)
//    list[0] = 0           // could not modify
}

/**
 * 惰性集合（序列）
 */
// bad way to operate large data
fun badOperating() {
    val list = listOf(1, 2, 3, 4)
    // 当数据量非常大时，这种效率很低
    // 1、filter 产生了一个新的List
    // 2、map    也产生了一个新的List
    list.filter { it > 2 }.map { it * 2 }
}

fun goodOperating() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // 1、filter 和 map 没有产生额外的集合
    // 2、惰性求值（lazy evaluation）：在需要时才进行求值的计算方式
    // 3、链式操作
    // 4、序列可以是无限的
    // 好处：优化性能；能够构造出无限的数据类型
    // 与Java 8的Stream对比：Stream是一次性的，只能在Stream上遍历一次; Stream 可以并行处理（paralleStream），但是目前Kotlin还没有并行序列
    println(
            list.asSequence()
                    .filter {
                        println("filter($it)")
                        it > 2
                    }
                    .map {
                        println("map($it)")
                        it * 2
                    }
                    .toList()
    )
}

fun main() {
//    goodOperating()
    val naturalNumList = generateSequence(0) { it + 1 }
    println(naturalNumList.takeWhile { it <= 9 }.toList())
}
