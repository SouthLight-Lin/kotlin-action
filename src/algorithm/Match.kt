package algorithm

import com.sun.org.apache.xpath.internal.operations.Bool

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
fun isMatch2(text: String, pattern: String) : Boolean? {
    val memo = HashMap<String, Boolean>()

    fun dp(i: Int, j: Int): Boolean? {
        val key = "($i,$j)";
        if (key in  memo) return memo[key]
        if (j == pattern.length)    return i == text.length

        val first: Boolean = i<text.length && (pattern[j] == text[i] || pattern[j] == '.')
        var ans: Boolean
        if (j<=pattern.length-2 && pattern[j+1] == '*'){
            ans = dp(i, j+2)!! || (first and dp(i+1, j)!!)
        }
        else{
            ans = first and dp(i+1, j+1)!!
        }
        memo[key] = ans
        return ans
    }

    return dp(0, 0)
}

fun main() {
    val text = "aab"
    val pattern = "c*a*b"
    println(isMatch2(text, pattern))
}