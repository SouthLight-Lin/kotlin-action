package action.ch04._04

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class Button: View {
    override fun getCurrentState(): State? {
        return null
    }

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    /** 这个类跟Java中静态嵌套类的对等物，相当于静态嵌套类，如果要指定内部类，可以使用inner关键字 **/
    class ButtonState: State{

    }
}