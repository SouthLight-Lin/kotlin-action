package shangshou.caozuofu

import com.sun.xml.internal.fastinfoset.util.StringArray

/**
 * 集合操作符
 * map
 * filter
 * reduce
 * ...
 * @author SouthLight-Lin on 2019/9/28
 */

fun main(args: Array<String>) {
    val list = arrayListOf<Char>('a', 'b', 'c', 'd')
    val res = list.map { it-'a' }
            .filter { it > 0 }
            .findLast { it > 1 }
    println(res)

    val a = arrayOf("4","0","7", "i","f","w","0","9")
    val index = arrayOf(5,3,9,4,8,3,1,9,2,1,7)

    index.filter { it < a.size }
            .map { a[it] }
            .reduce { s, s1 ->  "$s$s1"}
            .also { println("密码是:$it") }

    myOperator()

}

fun myOperator(){
    val list = listOf<Int>(1,2,3,4,5)
    list.convert { it+1 }
            .forEach{
                print(it)
            }
}

inline fun <T,E> Iterable<T>.convert(action: (T) -> E): MutableList<E>{
    val list: MutableList<E> = mutableListOf()
    for (item in this) list.add(action(item))
    return list
}