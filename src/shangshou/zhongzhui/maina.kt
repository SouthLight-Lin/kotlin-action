package shangshou.zhongzhui

/**
 * 重罪表达式
 * @author SouthLight-Lin on 2019/9/28
 */

sealed class CompareResult{
    object LESS: CompareResult(){
        override fun toString(): String {
            return "小于"
        }
    }

    object EQUAL: CompareResult(){
        override fun toString(): String {
            return "等于"
        }
    }

    object MORE: CompareResult(){
        override fun toString(): String {
            return "大于"
        }
    }
}

infix fun Int.vs(num: Int): CompareResult =
        when {
            this - num > 0 -> CompareResult.MORE
            this - num < 0 -> CompareResult.LESS
            else -> CompareResult.EQUAL
        }

fun main(args: Array<String>) {
    println(5 vs 6)
}

