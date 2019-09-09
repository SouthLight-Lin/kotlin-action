package action.ch02

import java.io.BufferedReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

/**
 * 异常
 * Kotlin没有区分已检查和未检查的异常
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */

fun tryException(percentage: Int){
    if (percentage !in 0..100){
        throw IllegalArgumentException("must be between 0 and 100：$percentage")
    }
}

fun readNumber(reader: BufferedReader){
    // try作为表达式
    val number = try{
        Integer.parseInt(reader.readLine())
    }catch (e: NumberFormatException){
        null
    }
    println(number)
}