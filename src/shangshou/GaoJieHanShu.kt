package shangshou

/**
 * 高阶函数
 * Created by linnanwei on 2019/9/23
 * @author linnanwei
 */

inline fun onlyIf(isDebug: Boolean, block: () -> Unit) {
    if (isDebug) block()
}

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun sum(x: Int, y: Int) = x + y

fun main(args: Array<String>) {

    val runnable = Runnable {
        println("Runnable::run")
    }

    // 参数为空，返回值为Unit的函数
    val function: () -> Unit

    function = runnable::run

    onlyIf(true, function)


    val sumResult = calculate(4, 5, ::sum)
    val mulResult = calculate(4, 5) { a, b ->
        a * b
    }
    println("sumResult $sumResult, mulResult $mulResult")

}