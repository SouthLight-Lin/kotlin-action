package action.ch04._07

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
// 主构造函数属性
class PrivateUser(override val nickName: String): User

class SubscribingUser(val email: String): User{
    override val nickName: String
        // 自定义getter
        get() = email.substringBefore('@')

}

class FacebookUser(val accountId: Int): User{
    override val nickName = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return "id_$accountId"
    }
}

fun main() {
    println(PrivateUser("test@kotlinlang.org").nickName)
    println(SubscribingUser("test@kotlinlang.org").nickName)
}