package shangshou

/**
 * Kotlin中如何比较对象
 * Kotlin: a==b   等价于 Java： a.equals(b)
 * Kotlin: a===b  等价于 Java：a == b
 * @author SouthLight-Lin on 2019/9/28
 */
fun main(args: Array<String>) {
    val string = "string"
//    val javaString = java.lang.String("string")
    val newString1 = StringBuilder("string").toString()
    val newString2 = String("string".toByteArray())

    println(string === newString1)
    println(string == newString1)
    println(string === newString2)
    println(string == newString2)
}