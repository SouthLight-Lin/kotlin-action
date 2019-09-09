/**
 * Created by linnanwei on 2019/9/5
 * @author linnanwei
 */
fun main() {
    println("Hello World, Hello Kotlin")
}
// Int参数，返回Int值
public fun sum(a: Int, b: Int): Int{
    return a+b
}

fun printSum(a: Int,b: Int): Unit {
    print(a+b)
}

// 可变长参数函数
fun vars(vararg v:Int){
    for (vt in v){
        print(vt)
    }
}

fun main(args: Array<String>) {
//    vars(1,2,3,4,5)
    // lambda匿名函数
    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
    print(sumLambda(1,2))

    // 类型后面加?标识可为空
    var age: String? = ""
    // 如果为空抛出异常
    val ages = age!!.toInt()

    val str:String = "a"
    val str1 = "a"
    val str2:String = "a" + "b"
    val str3:String  = "a$str2" // 拼接str2
    str2.plus("name")
    val a: String? = null

    // 如果为空不做处理，返回null
    val ages1 = age?.toInt()
    // age为空返回-1
    val ages2 = age?.toInt()?:-1;
}
