package action.ch04._05

/**
 * 密封类：sealed，限制了创建子类的可能性，所有的直接子类都必须被嵌套在超类中
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
sealed class Expr {
    // 子类的声明
    class Num(val value: Int): Expr()
    class Sum(val left: Expr, val right: Expr): Expr()
}

fun eval(e: Expr): Int =
    when(e){
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
        // 不需要else的分支
    }