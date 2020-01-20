package algorithm

/**
 * 格雷码
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/21
 */

fun circularPermutation(n1: Int, start1: Int): MutableList<Int> {
    var n = n1
    var start = start1
    val res = mutableListOf(start)
    var b = start
    while (start != 0) {
        b = b xor start
        start = start shr 1
    }
    // 总个数
    n = (1 shl n) - 1
    for (i in 1..n) {
        res.add(b + i and n xor (b + i and n) shr 1)
    }
    return res
}

fun main(args: Array<String>) {
    println(circularPermutation(2, 3))
}