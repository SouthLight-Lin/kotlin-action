package action.ch02

/**
 * Kotlin中public 是默认的可见性，可忽略它
 * Created by linnanwei on 2019/9/9
 *
 * @author linnanwei
 */
class Person(
    val name: String,     //1 会自动生成只读获取器
    var isMarried: Boolean)  //2 可变属性，自动生成获取器和设置函数
