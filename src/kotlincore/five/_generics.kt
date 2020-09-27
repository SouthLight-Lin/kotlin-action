package kotlincore.five

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * @author linnanwei
 * @since 1.0.0
 */
open class Fruit(val weight: Double)
class Apple(weight: Double): Fruit(weight)
class Banana(weight: Double): Fruit(weight)

/**
 * 上界约束
 */
class FruitPlate<T: Fruit>(val t: T)

// 多条件约束

interface Ground{}
class Watermelon(weight: Double): Fruit(weight), Ground

// 该方法只能[切]长在地上的水果
fun <T> cut(t: T) where T: Fruit, T: Ground {
    println("you can cut me.")
}

// 能获取所有类型信息的泛型类
open class GenericsToken<T> {
    var type: Type = Any::class.java
    init {
        val superClass = this.javaClass.genericSuperclass
        type = (superClass as ParameterizedType).actualTypeArguments[0]
    }
}

// 内联函数
/**
 * 编译器会将响应函数的字节码插入调用的地方（不需要方法的出栈入栈了）
 * reified：参数类型也会被插入字节码中
 */
inline fun <reified T> getType(): Class<T> {
    return T::class.java
}

// 协变；out
/**
 * @see List <out T>
 * 在泛型参数前加上out关键字，说明这个泛型类以及泛型方法是协变的
 * 泛型协变的Collection，一经创建就不可修改（这是代价）
 * 简单的说：out关键字声明的泛型参数类型将不能作为方法的参数类型
 * 作用：只能作为消费者，只能读取不能添加
 */
interface ReadableList<out T> {
//    fun add(t: T): Int          // 不允许
    fun get(index: Int): T      // 允许
}

// 逆变：in
/**
 * see MutableList.sortWith
 * 简单的说：in关键字声明的泛型参数不能当做方法的返回值类型，但可以作为方法的参数入参
 * 用处：只能作为生产者，只能添加，读取有限
 */
interface WritableList<in T> {
    fun add(t: T): Int          // 允许
//    fun get(index: Int): T     // 不允许
}


fun main() {
    cut(Watermelon(3.0))    // √
//    cut(Apple(2.0))         // ×

    val appleArray = arrayOfNulls<Apple>(3)
//    val anyArray: Array<Any?> = appleArray      // ×, it can compile pass by Java but not in Kotlin

    val list1 = ArrayList<String>()
    val list2 = object : ArrayList<String>(){}      // 匿名内部类
    println(list1.javaClass.genericSuperclass)      // java.util.AbstractList<E>
    println(list2.javaClass.genericSuperclass)      // java.util.ArrayList<java.lang.String>

    /**
     * 匿名内部类在初始化的时候，就会绑定父类或父类接口的响应信息
     */
    val gt = object : GenericsToken<Map<String, String>>(){}
    println(gt.type)
    println(getType<Map<String, String>>()) // 使用内联函数也可以获取参数类型

    val list: MutableList<*> = mutableListOf(1, "kotlin")

    val dest = arrayOfNulls<Number>(3)
    val src = arrayOf<Double>(1.0, 2.0, 3.0)
    copyIn(dest, src)
    copyOut(dest, src)
}

// T为Double
fun <T> copyIn(dest: Array<in T>, src: Array<T>) {
    if (dest.size < src.size) {
        throw IllegalArgumentException()
    }
    src.forEachIndexed { index, value -> dest[index] = value }
}

// T为Number
fun <T> copyOut(dest: Array<T>, src: Array<out T>) {
    if (dest.size < src.size) {
        throw IllegalArgumentException()
    }
    src.forEachIndexed { index, value -> dest[index] = value }
}