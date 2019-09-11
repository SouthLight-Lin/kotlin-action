package action.ch04._04

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class Outer {
    /** inner关键字，会变成内部类，引用他们的外部类 **/
    inner class Inner{
        fun getOuterReference(): Outer = this@Outer
    }
}