package action.ch04._01

/**
 * Kotlin在类后面使用一个冒号代替Java中的implements和extends关键字
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class Button: Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun click() = println("I was clicked")
}

fun main(args: Array<String>) {
    val button = Button()
    button.showOff()   // 我是可调用的，我是可获取焦点的
    button.setFocus(true)  // 我获取到了焦点
    button.click()        // 我被点击
}