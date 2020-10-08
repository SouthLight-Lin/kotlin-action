package kotlincore.eight

import action.ch03.list
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KParameter
import kotlin.reflect.KProperty
import kotlin.reflect.KTypeParameter
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.declaredMemberExtensionFunctions
import kotlin.reflect.full.declaredMemberExtensionProperties
import kotlin.reflect.full.memberProperties

/**
 * 元编程
 *
 * @author linnanwei
 * @since 1.0.0
 */

data class User(
        val name: String,
        val age: Int
)

/**
 * a::class 类型是KClass，是Kotlin中描述类型的类型
 */
object Mapper {
    fun <A : Any> toMap(a: A) = run { // get A all property
        a::class.memberProperties.map {
            val p = it as KProperty<*>
            p.name to p.call(a)
        }.toMap()
    }
}

/**
 * -------------------
 */
sealed class Nat {
    companion object {
        object Zero : Nat()
    }

    // extension property
    val Companion._0
        get() = Zero

    fun <A: Nat> Succ<A>.preceed(): A {
        return this.prev
    }
}

data class Succ<N : Nat>(val prev: N) : Nat()

fun <A: Nat> Nat.plus(other: A): Nat = when (other) {
    is Succ<*> -> Succ(this.plus(other.prev))   // a + S(b) = S(a+b)
    else -> this
}

/**
 * Kotlin反射API
 */
data class Person(
        val name: String,
        val age: Int,
        var address: String
) {
    fun friendsName(): List<String> = listOf("Yison", "Jilen")
    fun <A> get(a: A): A {
        return a
    }
}

fun KMutablePropertyShow() {
    val p = Person("宫本武藏", 18, "杭州")
    val props = p::class.memberProperties
    for (prop in props) {
        when(prop) {
            is KMutableProperty<*> -> prop.setter.call(p, "合肥")
            else -> prop.call(p)
        }
    }
    println(p.address)
}
fun KParameterShow() {
    val p = Person("孙尚香", 18, "汕头")
    for(c in Person::class.members) {
        print("${c.name} -> ")
        for (p in c.parameters) {
            print("${p.type} --")
        }
        println()
    }
}
fun KTypeShow() {
    Person::class.members.forEach {
        println("${it.name} -> ${it.returnType.classifier}")
    }
}
fun KTypeParameterShow() {
    for (c in Person::class.members) {
        if (c.name == "get") {
            println(c.typeParameters)
        }
    }
    val list = listOf<String>("how")
    println(list::class.typeParameters)
}

fun main() {
    println(Mapper.toMap(User("humora", 17)))

    println(Nat.Companion::class.isCompanion)
    println(Nat::class.isSealed)
    println(Nat.Companion::class.objectInstance)
    println(Nat::class.companionObjectInstance)
    println(Nat::class.declaredMemberExtensionProperties.map { it.name })
    println(Nat::class.declaredMemberExtensionFunctions.map { it.name })

    val _1 = Succ(Nat.Companion.Zero)
    val preceed = _1::class.members.find { it.name == "preceed" }
    println(preceed?.call(_1, _1) == Nat.Companion.Zero)

    println("===========property show===========")
    KMutablePropertyShow()
    println("===========parameter show===========")
    KParameterShow()
    println("===========return type show===========")
    KTypeShow()
    println("===========parameter type show===========")
    KTypeParameterShow()
}