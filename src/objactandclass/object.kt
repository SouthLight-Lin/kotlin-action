package objactandclass

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2020/1/20
 */

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {
    val dayRates = object {
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special

    println("Total price: $total")

}

fun main(args: Array<String>) {
    rentPrice(10, 2, 1)
}