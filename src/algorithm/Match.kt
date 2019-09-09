package algorithm

/**
 * Created by linnanwei on 2019/9/6
 * @author linnanwei
 */
/** 暴力破解 **/
fun isMatch(text: String, pattern: String) : Boolean{
    if (pattern.isEmpty()){
        return text.isEmpty()
    }
    // aaaaaaaa  a*
    val firstMatch:Boolean = text.isNotEmpty() && (pattern[0] == text[0] || pattern[0] == '.')
    // 发现 '*' 通配符
    if (pattern.length >= 2 && pattern[1] == '*'){
        return isMatch(text, pattern.substring(2)) ||
                firstMatch && isMatch(text.substring(1), pattern)
    }
    else
        return firstMatch && isMatch(text.substring(1), pattern.substring(1))
}

/**
 * 带备忘录的递归
 */
fun isMatch2(text: String, pattern: String) : Boolean{
    if (pattern.isEmpty()){
        return text.isEmpty()
    }
    // aaaaaaaa  a*
    val firstMatch:Boolean = text.isNotEmpty() && (pattern[0] == text[0] || pattern[0] == '.')
    // 发现 '*' 通配符
    if (pattern.length >= 2 && pattern[1] == '*'){
        return isMatch(text, pattern.substring(2)) ||
                firstMatch && isMatch(text.substring(1), pattern)
    }
    else
        return firstMatch && isMatch(text.substring(1), pattern.substring(1))
}

fun main() {
    val text = "aab"
    val pattern = "c*a*b"
    println(isMatch(text, pattern))
}