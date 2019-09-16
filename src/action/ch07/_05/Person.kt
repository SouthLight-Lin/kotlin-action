package action.ch07._05

/**
 * 用委托属性来实现惰性初始化
 * @author SouthLight-Lin on 2019/9/14
 */
class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware(){

    var age: Int by ObservableProperty(age, changeSupport)
    var salary : Int by ObservableProperty(salary, changeSupport)

    val emails by lazy {
        loadEmails(this)
    }

    private fun loadEmails(person: Person) {

    }
}