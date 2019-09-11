package action.ch04._11

import java.util.Comparator

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
data class Person(val name: String) {
    object NameComparator: Comparator<Person>{
        override fun compare(o1: Person, o2: Person): Int =
            o1.name.compareTo(o2.name)
    }
}

fun main(args: Array<String>) {
    val persons = listOf<Person>(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))
}