package action.ch09._03

/**
 * 协变：out
 * Created by linnanwei on 2019/9/17
 * @author linnanwei
 */
class Herd<out T: Animal>(private val animals: List<T>) {

    operator fun get(i: Int): T {
        return animals[i]
    }

    val size: Int get() = 10;
}

fun feedAll(animals: Herd<Animal>){
    for( i in 0 until animals.size){
        animals[i].feed()
    }
}

class Cat: Animal(){
    fun cleanLitter(){

    }
}

fun takeCareOfCats(cats: Herd<Cat>){
    for(i in 0  until cats.size){
        cats[i].cleanLitter()
        feedAll(cats)
    }
}