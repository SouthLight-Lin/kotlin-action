package action.ch03

/**
 * 拆分字符串
 * Kotlin 将正则表达式跟分割字符串分开
 * 如果输入的是正则表达式，则使用toRegex，否则就当做普通匹配字符串
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */

fun main(args: Array<String>) {
    // 显式的创建一个正则表达式
    println("12.345-6.A".split("\\.|-".toRegex()))
    // 指定多个字符串分割
    println("12.345-6.A".split(".", "-"))
    parsePathRegexp("F:\\Code\\kotlin-action\\src\\action\\ch03\\04SplitString.kt")

}


/** 分割出路径，文件名，扩展名 **/
fun parsePath(path: String){
    val directory = path.substringBeforeLast("\\")
    val fullName = path.substringAfterLast("\\")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name:$fileName, ext:$extension")
}


/** 使用正则表达式完成上述函数功能 **/
fun parsePathRegexp(path: String){
    val regex = """(.+)\\(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null){
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name:$filename, ext:$extension")
    }
}