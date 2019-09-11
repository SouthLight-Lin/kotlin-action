package action.ch05._04

/**
 * SAM构造函数：lambda变换函数式接口的显式的转换
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

fun createAllDoneRunnable(): Runnable{
    return Runnable { println("All done!") }
}

fun main(args: Array<String>) {
    createAllDoneRunnable().run()
}