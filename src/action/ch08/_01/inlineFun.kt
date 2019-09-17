package action.ch08._01

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * inline关键字声明内联函数,消除Lambda带来的运行时开销
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */

inline fun <T> synchronized(lock: Lock, action: () -> T) : T{
    lock.lock()
    try{
        return action()
    }
    finally {
        lock.unlock()
    }
}

fun main(args: Array<String>) {
    val l = ReentrantLock()
    synchronized(l){
        println("do lock coding")
    }
}