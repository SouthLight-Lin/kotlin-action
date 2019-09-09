package objactandclass

/**
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
open class Animal {

    private var name: String = "";

    init {
        println("Animal init")
    }

    constructor(){
        println("===Animal constructor executing===")
    }

    constructor(name: String) {
        this.name = name
    }


}