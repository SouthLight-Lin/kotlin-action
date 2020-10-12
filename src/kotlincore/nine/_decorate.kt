package kotlincore.nine

/**
 * 装饰者模式
 *
 * @author linnanwei
 * @since 1.0.0
 */
interface MacBook {
    fun getCost(): Int
    fun getDesc(): String
    fun getProdDate(): String
}

class MacBookPro: MacBook {
    override fun getCost(): Int = 10000
    override fun getDesc(): String = "Macbook Pro"
    override fun getProdDate(): String = "Late 2020"
}

// 装饰类
class ProcessorUpgradeMacbookPro(val macBook: MacBook): MacBook by macBook {
    override fun getCost(): Int = macBook.getCost() + 219
    override fun getDesc(): String = macBook.getDesc() + ", 32G Memory"
}

class Printer {
    fun drawLine() {
        println("——————————————")
    }
    fun drawDottedLine() {
        println("--------------")
    }
    fun drawStars() {
        println("**************")
    }
}
fun Printer.startDraw(decorated: Printer.() -> Unit) {
    println("+++ start drawing +++")
    this.decorated()
    println("+++ end   drawing +++")
}

fun main() {
    val processor = ProcessorUpgradeMacbookPro(MacBookPro())
    println(processor.getCost())
    println(processor.getDesc())
    println()
    Printer().run {
        startDraw {
            drawLine()
        }
        println()
        startDraw {
            drawDottedLine()
        }
        println()
        startDraw {
            drawStars()
        }
    }
}