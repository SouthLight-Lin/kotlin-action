package action.ch04._01

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}