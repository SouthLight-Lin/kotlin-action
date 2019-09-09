package two

/**
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
// 高阶函数（函数中的参数为函数）
// Lambda表达式会被编译成匿名内部类
inline fun onlyIf(isDebug: Boolean, block:() -> Unit){
    if (isDebug) block()
}

fun main(args: Array<String>) {
    // 实现Runnable对象
    val runnable = Runnable {
        println("Runnable::run")
    }
    // 创建一个Unit函数
    val function: () -> Unit
    // 将Runnable对象的run赋给function
    function = runnable::run

    onlyIf(true, function)

    lambdaA(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24)
}

val lambdaA = {
    a:Int, b:Int, c:Int, d:Int, e:Int, f:Int, g:Int, h:Int, i:Int, j:Int, k:Int, l:Int, m:Int, n:Int,
        o:Int, p:Int, q:Int, r:Int, s:Int, t:Int, u:Int, v:Int, w:Int, x:Int ->
    println("LNW")
}

// 使用内联优化代码
// 使用inline修饰方法，这样当方法在编译时就会拆解方法的调用为语句调用，进而减少创建不必要的对象
