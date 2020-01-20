package algorithm

/**
 * 生成括号
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/7
 */
class GenerateParenthesis {

    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()
        if (n == 0) {
            return res
        }
        dfs("", n, n, res)
        return res
    }

    /**
     * 解法一：深度遍历+剪枝
     */
    private fun dfs(curStr: String, left: Int, right: Int, res: MutableList<String>) {
        if (left == 0 && right == 0) {
            res.add(curStr)
            return
        }

        // 先一直生成左括号
        if (left > 0) {
            dfs("$curStr(", left - 1, right, res)
        }

        // 拼完左括号后，尝试拼接右括号，左括号的剩余数量要小于右括号的剩余数量
        if (right > 0 && left < right) {
            dfs("$curStr)", left, right - 1, res)
        }

        // 其他情况剪枝
    }

    /**
     * 解法二：动态规划
     * dp["i"] = "(" + dp["j"] + ")" + dp["i-j-1"] ，j=0,1,...,i-1
     */
    fun dp(n: Int): List<String> {
        if (n == 0) {
            return emptyList()
        }
        val dp = mutableListOf<List<String>>()
        val dp0 = listOf("")
        dp.add(dp0)

        for (i in 1..n) {
            val cur = mutableListOf<String>()
            for (j in 0 until i) {
                // 可能出现的括号对
                val str1 = dp[j]
                // 剩余的括号对
                val str2 = dp[i - 1 - j]
                for (s1 in str1) {
                    for (s2 in str2) {
                        // 枚举各个括号的位置
                        cur.add("($s1)$s2")
                    }
                }
            }
            dp.add(cur)
        }
        return dp[n]
    }

}

fun main(args: Array<String>) {
    val solution = GenerateParenthesis()
    println(solution.generateParenthesis(3))
    println(solution.dp(3))
}