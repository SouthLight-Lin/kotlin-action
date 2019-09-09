package two

/**
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
fun main(args: Array<String>) {
    // 如果函数没有参数，箭头可省略
//    val thread = Thread({ })
//    // 如果函数只有一个参数且参数是Lambda，则可以省略小括号
//    val thread2 = Thread {}
//    thread.start()
//    thread2.start()
    print("hello")

}

// Lambda闭包，注：Lambda参数最多只支持22个，Kotlin的Lambda编译的时候会被编译成匿名内部类
val print = { name: String ->
    println(name)
}