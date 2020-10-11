package kotlincore.nine

import kotlin.properties.Delegates

/**
 * 对某些改值时进行否决(vote)
 *
 * @author linnanwei
 * @since 1.0.0
 */
var value: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    newValue > 0
}

fun main() {
    value = 1
    println(value)
    value = -1      // it doesn't work
    println(value)  // print 1 again
}