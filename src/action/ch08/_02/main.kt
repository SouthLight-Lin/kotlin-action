package action.ch08._02

/**
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */

data class Person(val name: String, val age: Int)

val people = listOf<Person>(Person("Alice", 29), Person("Bob", 31))

fun lookForAlice(persons : List<Person>){
    for (person in persons){
        if (person.name == "Alice"){
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun lookForAliceLambda(persons: List<Person>){
    persons.forEach{
        if (it.name == "Alice"){
            println("Found!")
            return          // 非局部返回
        }
    }
    println("Alice is not found")
}

/** 使用标签，局部返回 **/
fun lookForAliceLocal(persons: List<Person>){
    // 用一个标签实现局部返回
    persons.forEach label@{
        if (it.name == "Alice"){
            println("Found!")
            return@label
        }
    }
    // 用函数名作为return标签
    persons.forEach {
        if (it.name == "Alice"){
            println("Found!")
            return@forEach
        }
    }
    println("Alice might be somewhere")
}

fun main(args: Array<String>) {
    lookForAlice(people)
    lookForAliceLambda(people)
    lookForAliceLocal(people)

    /** filter中使用匿名函数，完成局部返回 **/
    people.filter(fun (person): Boolean{
        return person.age < 30  // 这样会回退到filter后，不会跳出函数
    })
}