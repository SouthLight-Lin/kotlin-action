import kotlin.reflect.KClass

/**
 * Created by linnanwei on 2019/9/6
 * @author linnanwei
 */

fun testClass(clazz: Class<JavaMain>){
    println(clazz.simpleName)
}

fun testClass(clazz: KClass<KotlinMain>){
    println(clazz.simpleName)
}

fun main(args: Array<String>) {
    testClass(JavaMain::class.java)
    testClass(KotlinMain::class)
    val  str = "SouthLight-Lin"
    var  name = "name: $str"
    print(name)
}