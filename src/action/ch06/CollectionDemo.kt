package action.ch06

/**
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */
fun main(args: Array<String>) {
    val result = ArrayList<Int?>()  // 创建可空Int列表
    result.add(null)

    val fiveZeros = IntArray(5)
    val fiveZerosToo = intArrayOf(0,0,0,0,0)
    val squares = IntArray(5) {i -> (i+1) * (i+1)}

    squares.forEachIndexed { index, element ->
        println("Argument $index is :$element")
    }
}

fun addValidNumbers(numbers: List<Int?>){
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}