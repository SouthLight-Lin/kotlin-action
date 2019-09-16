package action.ch07._05

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

/**
 * @author SouthLight-Lin on 2019/9/14
 */
open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.removePropertyChangeListener(listener)
    }
}