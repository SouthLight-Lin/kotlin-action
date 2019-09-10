package action.ch03

/**
 * 中缀调用(infix call)
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
fun main(args: Array<String>) {
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    val (number, name) = 1 to "one"
    println(number)
    println(name)
}

infix fun Any.to(other: Any) = Pair(this, other)
