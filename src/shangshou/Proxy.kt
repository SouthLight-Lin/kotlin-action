package shangshou

/**
 * Kotlin的动态代理
 * Created by linnanwei on 2019/9/23
 * @author linnanwei
 */
interface Animal{
    fun bark()
}

class Dog: Animal{
    override fun bark() {
        println("Wang")
    }
}

/** 让Animal代理 **/
class Zoo(animal: Animal): Animal by animal{
    override fun bark() {
        println("zoo")
    }
}

fun main(args: Array<String>) {
    Zoo(Dog()).bark()
}