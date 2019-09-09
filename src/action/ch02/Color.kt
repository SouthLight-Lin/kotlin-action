package action.ch02

import java.lang.Exception

/**
 * 枚举类
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
enum class Color(val r:Int, val g:Int, val b:Int) {
    RED(255,0,0), ORANGE(255,265,0),
    YELLOW(255,255,0),BLUE(0,0,255),
    GREEN(0, 255, 0);
    // 上面那个分号是必须的
    fun rgb() = (r * 256 + g) * 256 + b
}


fun getMnmonic(color: Color) =
    when(color){
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Grave"
        Color.BLUE -> "Battle"
    }

/**
 * when可以是任意对象
 */
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)){
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        else -> throw Exception("Dirty color")
    }

/**
 * 不带参数的when
 */
fun mixOptimized(c1: Color, c2: Color) =
    when{
        c1 == Color.RED && c2 == Color.YELLOW -> Color.ORANGE
        c1 == Color.YELLOW && c2 == Color.BLUE -> Color.GREEN
        else -> throw Exception("Dirty color")
    }

fun main(args: Array<String>) {
    println(getMnmonic(Color.BLUE))
    println(mix(Color.BLUE, Color.YELLOW))
    println(mixOptimized(Color.RED, Color.YELLOW))
}
