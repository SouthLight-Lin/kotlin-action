package action.ch06

/**
 * 安全调用运行符 ?.
 * Elvis运算符  ?:
 * 安全转换运算符 as?
 * 非安全解析运算符，非空断言 !!
 *
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

fun main(args: Array<String>) {
    println(strLenSafe(null))
//    println(ignoreNulls(null))

    val email: String? = null
    // 使用let函数，当email不为空时执行表达式
    email?.let { sendEmailTo(it) }
}

fun strLen(s: String) = s.length
/**s: String? 运行传入空值**/
/** 使用安全调用运算符："?." **/
fun strLenSafe(s: String?) = s?.length ?: 0

/** 非空断言："!!" **/
fun ignoreNulls(s: String?){
    val sNotNull: String = s!!   //如果s为空，则在这里抛出异常
    println(sNotNull.length)
}

// 不允许传递空值进来
fun sendEmailTo(email: String){
    // ...
    println(email)
}

fun verifyUserInput(input: String){
    if (input.isNullOrBlank()){
        println("Is null or blank")
    }
}