package action.ch07._05

import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

/**
 * 作为属性委托
 * @author SouthLight-Lin on 2019/9/14
 */
class ObservableProperty(var propValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(p: Person, prop: KProperty<*>) : Int = propValue

    operator fun setValue(p: Person, prop: KProperty<*>, newValue: Int){
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}