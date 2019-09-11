package action.ch05._03

import java.io.File
import java.lang.StringBuilder

/**
 * with函数，消除重复
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

fun alphabet(): String{
    val stringBuilder = StringBuilder()
    // 1 在你调用的方法中指定接收器的值
    return with(stringBuilder){
        for( letter in 'A'..'Z'){
            // 2 通过显式的"this"调用接收器值的方法
            this.append(letter)
        }
        // 3 调用方法，直接忽略this
        append(("\nNow I know the alphabet!"))
        // 4 从Lambda中返回值
        this.toString()
    }
}

/** let跟also的结合使用 **/
fun makeDir(path: String): File =
    path.let { File(it) }.also { it.mkdirs() }

