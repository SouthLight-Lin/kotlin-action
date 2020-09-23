package kotlincore.two

/**
 * @author linnanwei
 * @since 1.0.0
 */

fun foo(x: Int) = {y: Int -> x+y}
// 等价于 柯里化（Currying）语法
fun fooDetail(x: Int): (Int) -> Int {
    return {y: Int -> x+y}
}

fun sum(x: Int) = { y: Int ->
    {z: Int -> x+y+z}
}

fun omitParentheses(block: () -> Unit) {
    block()
}

fun curryingLike(content: String, block: (String) -> Unit) {
    block(content)
}

class Person{
    infix fun call(name: String) {
        println("My name is $name.")
    }
}

/**
 * by lazy property
 */
class Bird(val weight: Double, val age: Int, val color: String) {
    /**
     * 1、by lazy 必须是val 类型参数
     * 2、在被首次调用时，才会进行复制操作
     * 3、默认是线程安全（LazyThreadSafetyMode.SYNCHRONIZED），默认加上同步锁，初始时只允许一个线程初始化该值
     */
    val sex: String by lazy {
        if (color == "yellow") "male" else "female"
    }
    // 并行模式
    val sexParallel: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        if (color == "yellow") "male" else "female"
    }
    // 不做任何线程开销
    val sexNone: String by lazy(LazyThreadSafetyMode.NONE) {
        if (color == "yellow") "male" else "female"
    }
}

/**
 * lateinit property
 */
class Cat(val weight: Double, val age: Int, val color: String) {
    /**
     * 1、主要用于var声明的变量
     * 2、不能用于基本数据类型，如Int、Long等
     */
    lateinit var sex: String
    fun printSex() {
        this.sex = if (this.color == "yellow") "male" else "female"
        println(this.sex)
    }
}

fun main() {
    val person = Person()
    person call "linnanwei"
    curryingLike("looks like currying style") {
        println(it)
    }
    omitParentheses {
        println("省略了括号，直接使用{}")
    }
    println(sum(1)(2)(3))
    val bar = {x: Int, y: Int -> x+y}
    listOf(1,2,3).forEach { bar(it,1) }
}