package kotlincore.nine

/**
 * 策略模式
 * @author linnanwei
 * @since 1.0.0
 */
interface SwimStrategy {
    fun swim()
}

/** 蛙泳 */
class Breaststroke: SwimStrategy {
    override fun swim() {
        println("I am breaststroke...")
    }
}
/** 背泳 */
class Backstroke: SwimStrategy {
    override fun swim() {
        println("I am backstroking...")
    }
}
/** 自由泳 */
class Freestyle: SwimStrategy {
    override fun swim() {
        println("I am freestyling...")
    }
}
/**
 * 使用策略模式组合不同的游泳方法
 * 实现了不同场景的切换
 * 但是代码不够简洁
 */
class Swimmer(private val strategy: SwimStrategy) {
    fun swim() {
        strategy.swim()
    }
}

/** 利用高阶函数抽象算法 **/
fun breaststroke() { println("I am breaststroke...") }
fun backstroke() { println("I am backstroking...") }
fun freestyle() { println("I am freestyling...") }

class SwimmerLambda(val swimming: () -> Unit) {
    fun swim() {
        swimming()
    }
}

fun main() {
    val weekendShaw = SwimmerLambda(::freestyle)
    weekendShaw.swim()
    val weekdaysShaw = SwimmerLambda(::backstroke)
    weekdaysShaw.swim()
}