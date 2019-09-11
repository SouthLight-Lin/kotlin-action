package action.ch04._02

/**
 * 抽象类不能被初始化（跟Java一样），
 * 一个抽象类通常包含抽象成员，其不需要具体实现但必须在子类中重写
 * 抽象成员总是开放的，因此你不需要显式的使用open修饰符
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
abstract class Animated {
    /** 这个函数式抽象的：它并没有实现，所以需要子类实现 **/
    abstract fun  animate()
    /** 抽象类中的非抽象方法默认是不开放的，但是看可以被标注为开放的 **/
    open fun stopAnimating(){

    }
    /** 抽象类中的非抽象方法默认是不开放的 **/
    fun animateTwice(){

    }
}