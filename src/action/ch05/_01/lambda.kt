package action.ch05._01

import action.ch05.Person

/**
 * Kotlin没有严格限制你访问final变量，你可以从Lambda中修改变量
 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

val sum = {x: Int, y: Int -> x+y}

fun printMessageWithPrefix(messages: Collection<String>, prefix: String){
    messages.forEach{
        println("$prefix $it")
    }
}

/**
 * 与Java不同，Kotlin允许你访问非不可修改的变量，甚至在Lambda中修改他们
 */
fun printProblemCounts(responses: Collection<String>){
    // 声明通过lambda访问变量
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach{
        // 修改lambda中的变量
        if (it.startsWith("4")){
            clientErrors++;
        }
        else if (it.startsWith("5")){
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors" )
}

val createPerson = ::Person

fun main(args: Array<String>) {
    println(sum(1, 2))
    // 直接调用Lambda表达式，使用run关键字
    run { println("Hello, Lambda") }

    val people = listOf<Person>(Person("Alice", 20), Person("Bob", 31))

    val names = people.joinToString(separator = " ") { person: Person -> person.name }
    println(names)
    println(people.maxBy { p: Person -> p.age })
    val errors = listOf<String>("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Error:")
    val responses = listOf<String>("200 OK", "418 I am a teapot", "500 Internal Server Error")
    printProblemCounts(responses)
    println(createPerson("Alice", 20))
}