package action.ch04._13

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

/**
 * 匿名内部类的另一种表达式
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */

val listener = object : MouseAdapter(){

}

fun init(window: Window){
    var clickCount = 0

    window.addMouseListener(object : MouseAdapter(){
        override fun mouseClicked(e: MouseEvent?) {
            clickCount++
        }
    })
}