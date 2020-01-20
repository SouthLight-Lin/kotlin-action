package objactandclass

/**
 * 密封类
 * 只能从声明密封类的同一文件内对其进行子类化
 * 不能在声明密封类的文件之外对它进行子类化
 *
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2020/1/20
 */

sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    return when (mammal) {
        // smartcast
        is Human -> "Hello ${mammal.name}; You're working as a ${mammal.job}"
        // smartcast
        is Cat -> "Hello ${mammal.catName}"
    }
}

fun main(args: Array<String>) {
    println(greetMammal(Cat("Snowy")))
    println(greetMammal(Human("SouthLight", "Java-Player")))
}