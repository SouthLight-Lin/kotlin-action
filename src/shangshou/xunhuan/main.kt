package shangshou.xunhuan

/**
 * 循环语法
 * @author SouthLight-Lin on 2019/9/28
 */

/** 五种循环语法 **/
fun yufa(){
    for (i in 0..10){ }

    for (i in 0 until 10){}

    for (i in 10 downTo 1){}

    for (i in 1..10 step 2){}

    repeat(10){}
}

fun main(args: Array<String>) {
    repeat(10){
        println(it)
    }
}