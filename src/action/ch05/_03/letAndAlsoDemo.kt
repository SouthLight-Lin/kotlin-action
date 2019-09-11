package action.ch05._03

/**
 *
 * let函数可以改变当前对象的状态
 * also则不可以，also用于不更改对象操作，例如用于记录或打印调试信息
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

data class Person(var name:String, var age:Int, var address: String){
    fun moveTo(address: String){
        this.address = address
    }

    fun incrementAge(){
        this.age++
    }
}

fun main(args: Array<String>) {
    println("123".let {
        println("$it")
        it.reversed()
    })
    // also最后还是123
    println("123".also {
        println("$it")
        it.reversed()
    })

    Person("Alice", 20, "Amsterdam").let {
        println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }

    val numberList = mutableListOf<Double>()
    numberList.also{ println("Populating the list!")}
        .apply { add(2.71)
            add(3.14)
            add(1.0)
        }
        .also { println("Sorting the list") }
        .sort()

}
