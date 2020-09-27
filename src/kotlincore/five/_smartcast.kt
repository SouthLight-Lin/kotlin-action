package kotlincore.five

import action.ch03.User

class Kot {
    private val stu: User? = getUser() as? User
    fun dealStu() {
        if (stu != null) {
            // 其他线程也有可能修改该值
            println(stu.address)
        }
    }

    fun getUser(): User? = null
}

inline fun <reified T> cast(original: Any): T? = original as? T
fun main(args: Array<String>) {
    println(cast<String>(12345L))
}
