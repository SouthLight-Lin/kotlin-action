package action.ch08._01

import java.io.BufferedReader
import java.io.FileReader

/**
 * use函数是一个扩展函数，被用来操作可关闭的资源
 * 它接受一个Lambda作为参数，这个方法调用Lambda并且确保资源被关闭
 * use函数式内联函数，所以使用它并不会引发任何性能开销
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */

fun readFirstLineFromFile(path: String): String{
    BufferedReader(FileReader(path)).use { br ->
        return br.readLine() // 从函数总返回文件的一行
    }
}