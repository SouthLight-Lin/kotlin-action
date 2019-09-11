package action.ch04._08

/**
 * getter或者setter访问支持字段
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class User(val name: String) {
    var address: String = "unspecified"
    set(value: String) {
        println("""
            Address was changed for $name:
            "$field" -> "$value"
        """.trimIndent())
        // 更新支持字段的值
        field = value
    }
}

fun main(args: Array<String>) {
    val user = User("Alice")
    // 会调用setter函数
    user.address = "China"
}