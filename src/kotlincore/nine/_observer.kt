package kotlincore.nine

import java.util.*
import kotlin.properties.Delegates

/**
 * 观察者模式
 *
 * @author linnanwei
 * @since 1.0.0
 */
/** 股市变化，Java接口的观察者 */
class StockUpdate: Observable() {
    private val observers = mutableSetOf<Observer>()

    fun setStockChanged(price: Int) {
        this.observers.forEach { it.update(this, price) }
    }
}
class StockDisplay: Observer {
    override fun update(o: Observable?, price: Any?) {
        if (o is StockUpdate) {
            println("the latest stock price is $price")
        }
    }
}

/** Kotlin版本的观察者 */
interface StockUpdateListener {
    fun onRise(price: Int)
    fun onFall(price: Int)
}

/**
 * 在Java版本中，每次更新都是调用update方法来编写响应逻辑
 * 如果有多个不同的响应逻辑，那么update会变得臃肿
 */
class KtStockDisplay: StockUpdateListener {
    override fun onRise(price: Int) {
        println("The latest stock price has risen to $price .")
    }

    override fun onFall(price: Int) {
        println("The latest stock price has fell to $price .")
    }
}

class KtStockUpdate {
    private val listeners = mutableSetOf<StockUpdateListener>()

    /**
     * Kotlin的委托属性实现观察者模式
     */
    var price : Int by Delegates.observable(0) { _, old, new ->
        listeners.forEach {
            if (new > old) it.onRise(price) else it.onFall(price)
        }
    }

    fun addListener(listener: StockUpdateListener) {
        listeners.add(listener)
    }
}

fun main() {
    val su = KtStockUpdate()
    val sd = KtStockDisplay()
    su.addListener(sd)
    su.price = 100
    su.price = 98
}
