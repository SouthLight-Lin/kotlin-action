package action.ch04._01

import action.ch04._01.Clickable

/**
 * open关键字：因为Kotlin默认所有的类和方法是final的，如果你想允许一个类创建一个子类
 * 你就需要open关键字修饰
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
/** 这个类是开放的：其他类可以继承它 **/
open class RichButton: Clickable {
    /** 这个类是不可修改的(final)， 你不可以在子类中覆盖它 **/
    fun disable(){}
    /** 这个函数式开放的：你可以在子类中覆盖它 **/
    open fun animate(){}
    /** 覆盖了一个开放的函数，同时它也是开放的 **/
    /** 如果加上final关键字，该函数将不开放 **/
    final override fun click() {

    }

}