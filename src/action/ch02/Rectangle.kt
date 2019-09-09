package action.ch02

/**
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get()  {
            return height==width
        }
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(41,43)
    println(rectangle.isSquare)
}