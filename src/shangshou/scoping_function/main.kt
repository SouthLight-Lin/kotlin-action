package shangshou.scoping_function

/**
 *
 * 作用域函数：Kotlin内置的可以对数据做变换的函数
 * run{}
 * with(T){}
 * let{}
 * apply{}
 * also{}
 * @author SouthLight-Lin on 2019/9/28
 */

data class User(var name: String)

data class Person(val name: String, val email: String)

fun main(args: Array<String>) {
    var user = User("lnw")

    /** let与run都会返回闭包的执行结果，区别在于let有闭包参数，而run没有闭包参数 **/
    val letRes = user.let { user: User -> "let::${user.javaClass}" }
    println(letRes)
    val runRes = user.run { "run::${this.javaClass}" }
    println(runRes)

    /** also与apply都不返回闭包的执行结果，区别在于also有闭包参数，apply没有闭包参数，可以作为链式操作 **/
    user = user.also { println("also::${it.javaClass}") }
    user.apply { println("apply::${this.javaClass}") }

    /** takeIf 的闭包返回一个判断结果，为false时，takeIf函数会返回空 **/
    user.takeIf { it.name.isNotEmpty() }?.also { println("姓名为：${it.name}") } ?: println("姓名为空")
    /** takeUnless 与 takeIf刚好相反，闭包的判断结果，为true时函数返回空 **/
    user.takeUnless { it.name.isNotEmpty() }?.also { println("姓名为空") } ?: println("姓名为：${user.name}")

    /** with比较特殊，不是以扩展方法的形式存在，而是一个顶级函数 **/
    with(user) {
        this.name = "with"
    }
    // 其实相当于
    user.apply { this.name = "with" }

    val (name, email) = Person("name", "email")

}
