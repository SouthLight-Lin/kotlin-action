package action.ch03.strings

/**
 * 扩展函数
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
/** 扩展函数（其实编译后就是个静态方法 **/
fun String.lastChar(): Char = this[this.length - 1]
/** 扩展属性 **/
val String.lastChar: Char get() = get(length-1)
fun main(args: Array<String>) {
    println("Kotlin".lastChar())
}