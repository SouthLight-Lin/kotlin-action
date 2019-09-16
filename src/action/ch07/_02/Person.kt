package action.ch07._02

/**
 * @author SouthLight-Lin on 2019/9/13
 */
class Person(val firstName: String, val lastName: String): Comparable<Person> {
    override fun compareTo(other: Person): Int {
        // 先比较姓氏，再比较名字
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}