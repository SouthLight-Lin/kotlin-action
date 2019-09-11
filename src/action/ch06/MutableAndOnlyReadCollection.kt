package action.ch06

/**
 * 只读集合和可变集合
 * Kotlin把访问集合的数据的接口和修改集合数据的接口分开了
 * 分为Collection 和 MutableCollection
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

fun <T> copyElements(source: Collection<T>,
                     target: MutableCollection<T>){
    for (item in source){
        target.add(item)
    }
}

fun  main(args: Array<String>) {
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(1)
    copyElements(source, target)
}

fun printInUppercase(list: List<String>){
    println(CollectionUtils.uppercaseAll(list))
    println(list.first())
}