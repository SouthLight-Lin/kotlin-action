package action.ch04._01

/**
 * Kotlin接口可以包含抽象方法的定义
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
interface Clickable {
    fun click()

    /** 带有默认实现的方法 **/
    fun showOff() = println("I'm clickable!")
}