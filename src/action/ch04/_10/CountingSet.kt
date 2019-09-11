package action.ch04._10

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>())
    : MutableCollection<T> by innerSet{ // 委托MutableCollection的实现给innerSet
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,1,2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}