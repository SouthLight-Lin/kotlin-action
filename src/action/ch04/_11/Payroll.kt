package action.ch04._11

import action.ch03.User

/**
 * 单例变得容易
 * 不能有构造函数
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
object Payroll {
    val allEmployee = arrayListOf<Any>()

    fun calculateSalary(){
        for(obj in allEmployee){
            // ...
        }
    }
}

fun main(args: Array<String>) {
    // 声明即创建
    Payroll.allEmployee.add(User(1,"",""))
    Payroll.calculateSalary()
}