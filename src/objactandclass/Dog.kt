package objactandclass

/**
 * Created by linnanwei on 2019/9/9
 * @author linnanwei
 */
// 接口跟父类的顺序没有要求
class Dog: Action, Animal {

    // 在构造方法前执行
    init {
//        println("This dog'name $name")
        println("dog init")
    }


    constructor(){
        println("Dog constructor executing")
    }

    private var name:String = "";


    constructor(name:String){
        this.name = name;
    }

    override fun doAction() {
        println("Dog do action")
    }
}