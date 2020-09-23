package kotlincore.four

/**
 * 使用密封类最大的好处就是使用when表达式的时候
 * 可以省略else分支，因为和类型是安全的
 * @author linnanwei
 * @since 1.0.0
 */
sealed class Day{
    class SUN: Day()
    class MON: Day()
//    class TUE: Day()
//    class WED: Day()
//    class THU: Day()
//    class FRI: Day()
//    class SAT: Day()
}

fun schedule(day: Day): Unit =
        when(day) {
            is Day.MON -> println("1")
            is Day.SUN -> println("7")
            // 无需else分支
        }

// when：模式匹配
// 1、常量匹配： when(a) { 1 -> .. 2-> ..}
// 2、类型匹配： when(a) {is type_a -> .. is type_b ->}
// 3、逻辑表达式模式：when{ a in range(2,11) -> .. else -> .. }
// 4、嵌套表达式： 详见Expr class

sealed class Expr{
    data class Num(val value: Int): Expr()
    // 复杂树形结构，opName代表操作符:+ - * /
    data class Operate(val opName: String, val left: Expr, val right: Expr): Expr()
}