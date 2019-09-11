package action.ch04._04

import java.io.Serializable

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
interface View {
    fun getCurrentState(): State?
    fun restoreState(state: State) {}
}

interface State: Serializable