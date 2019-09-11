package action.ch05._03

import action.ch05.Person

/**
 * apply函数，可以便利的使用建造者模式
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

fun main(args: Array<String>) {
    val car = Car().apply {
        type = "货车"
        weight = 100
        city  = "汕头"
    }
    println(car)
}

data class Car(var type:String = "轿车", var weight:Int = 15, var city: String = "中国广东")