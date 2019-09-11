package action.ch04._12

/**
 * 定义在类中的一个对象可以用一个特殊的关键字来标记：companion
 * 这样就能获得通过所在类的名字直接访问这个对象的方法和属性的能力
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class A {
    companion object{
        fun bar(){
            println("Companion object called")
        }
    }
}

fun main(args: Array<String>) {
    A.bar()
}