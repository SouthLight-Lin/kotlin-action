package action.ch07._05

import java.beans.PropertyChangeListener

/**
 * @author SouthLight-Lin on 2019/9/14
 */

fun main(args: Array<String>) {
    val p = Person("Dmitry", 34, 2000)
    p.addPropertyChangeListener(PropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}") })
    p.age = 35
    p.salary = 2100
}