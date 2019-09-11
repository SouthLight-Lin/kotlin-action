package algorithm

/**
 * 正则表达式匹配
 * 回溯算法
 * "*"匹配任意多个（大于等于0）任意字符，"?"匹配零个或一个任意字符
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class Pattern(
    var matched: Boolean = false,
    val pattern: CharArray,
    val plen: Int)
{
    fun match(text: CharArray, tlen: Int): Boolean{
        matched = false
        rmatch(0,0,text,tlen)
        return matched
    }

    private fun rmatch(ti: Int, pj: Int, text: CharArray, tlen: Int){
        if (matched)
            return;

        if (pj == plen){
            if (ti == tlen){
                matched = true
            }
            return
        }
        if (pattern[pj] == '*'){
            for (k in 0..tlen-ti){
                rmatch(ti+k, pj+1, text, tlen)
            }
        }
        else if (pattern[pj] == '?'){
            rmatch(ti, pj+1, text, tlen)
            rmatch(ti+1, pj+1, text, tlen)
        }
        // 匹配纯字符串
        else if (ti<tlen && pattern[pj] == text[ti]){
            rmatch(ti+1, pj+1, text, tlen)
        }
    }
}

fun main(args: Array<String>) {
    val pattern = Pattern(pattern = "a?a".toCharArray(), plen = 3)
    println(pattern.match("abcaa".toCharArray(), 4))
}