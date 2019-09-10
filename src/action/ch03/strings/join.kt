@file:JvmName("StringFunctions")
package action.ch03.strings

import java.lang.StringBuilder

/**
 * 顶层函数
 * 把函数放在代码文件的最顶层而不需要再类内部
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */

var opCount = 0  // 包级别的属性声明
const val UNIX_LINE_SEPARATOR = "\n"

/** 自定义输出格式 **/
//fun <T> joinToString(
//    collection: Collection<T>,
//    separator: String = ", ",   //默认参数
//    prefix: String = "",
//    postfix: String = ""
//): String{
//    val result = StringBuffer(prefix)
//
//    for ((index, element) in collection.withIndex()){
//        if (index > 0) result.append(separator)
//        result.append(element)
//    }
//
//    result.append(postfix)
//    return result.toString()
//}

/** 将上述函数整合到标准库的Collection中 **/
fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String{
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()){
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}