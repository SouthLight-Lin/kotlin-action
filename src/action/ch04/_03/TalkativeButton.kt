package action.ch04._03

import action.ch04._01.Focusable

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
internal  open class TalkativeButton: Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}
/**
 * 不能扩展TalkativeButton
 * 无法访问yell和whisper
 * */
//fun TalkativeButton.giveSpeech(){
//    yell()
//
//    whisper()
//}

/**
 * Kotlin进制从public访问性的giveSpeech函数引用低可见性类型的TalktiveButton
 * **/