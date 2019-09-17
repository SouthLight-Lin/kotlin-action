package action.ch09._03

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.reflect.KClass


/**
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */

fun main(args: Array<String>) {
    val list: MutableList<Any?> = mutableListOf('a', 1, "qwe")
    val chars = mutableListOf('a', 'b', 'c')
    val unknowElements: MutableList<*> =
        if (Random().nextBoolean()) list else chars
    println(unknowElements.first())



    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator
    val stringValidator = validators[String::class]
        as FieldValidator<String>
    println(stringValidator.validate(""))

    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultIntValidator)
    println(Validators[String::class].validate("Kotlin"))
    println(Validators[Int::class].validate(42))
}

fun <T: R, R> copyData(source: MutableList<T>, destination: MutableList<R>){
    for (item in source){
        destination.add(item)
    }
}

interface FieldValidator<in T>{
    fun validate(input: T): Boolean
}

object DefaultStringValidator: FieldValidator<String>{
    override fun validate(input: String): Boolean {
        return input.isEmpty()
    }
}

object DefaultIntValidator: FieldValidator<Int>{
    override fun validate(input: Int): Boolean {
        return input >= 0
    }
}

object Validators{
    private val validators =
        mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T: Any> registerValidator(kClass: KClass<T>,
                                   fieldValidator: FieldValidator<T>){
        validators[kClass] = fieldValidator
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T:Any> get(kClass: KClass<T>): FieldValidator<T> =
        validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}