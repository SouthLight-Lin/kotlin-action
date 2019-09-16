package action.ch08

/**
 * 返回函数的函数
 * @author SouthLight-Lin on 2019/9/16
 */
enum class Delivery{STANDARD, EXPEDITED}

class Order(val itemCount: Int)

fun getShippingCostCalculator(
        delivery: Delivery): (Order) -> Double{ // 声明一个返回函数的函数
    if (delivery == Delivery.EXPEDITED){
        return {order -> 6 + 2.1 * order.itemCount }
    }
    return {order -> 1.2 * order.itemCount }
}

fun main(args: Array<String>) {
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calculator(Order(3))}")
}