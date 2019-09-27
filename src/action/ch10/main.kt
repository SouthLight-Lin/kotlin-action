package action.ch10

import kotlin.reflect.full.memberProperties

/**
 * Created by linnanwei on 2019/9/23
 * @author linnanwei
 */
fun main(args: Array<String>) {
    val person = Person("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)

    kClass.memberProperties.forEach{ println(it.name) }

    val kFunction = ::foo
    kFunction.call(42)

    fun sum(x: Int, y:Int) = x + y
    val kFunction2 = ::sum
    // 反射调用sum方法
    println(kFunction2.invoke(1,2) + kFunction2.invoke(3, 4))

    val person2 = Person("Alice", 29)
    val memberProperty = Person::age
    // 反射调用person的get方法
    println(memberProperty.get(person2))

}


fun foo(x: Int) = println(x)